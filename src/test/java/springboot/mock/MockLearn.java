/**
 * @projectName learn
 * @package springboot.mock
 * @className springboot.mock.MockLearn
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.mock;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import lombok.SneakyThrows;

/**
 * MockLearn
 *
 * @description 
 * @author wangjing
 * @date 2020/10/9 10:35
 * @version v1.0.0
 */
public class MockLearn {

    /**
     * use mockito's verify to test it's behavior.(this mockList is proxy object, not common)
     */
    @Test
    public void verifyBehavior() {
        List mockList = Mockito.mock(List.class);
        mockList.add(1);
        mockList.clear();
        Mockito.verify(mockList).add(1);
        Mockito.verify(mockList).clear();
    }

    /**
     * define iterator's behavior then test it's use
     */
    @Test
    public void returnBehavior() {
        Iterator iterator = Mockito.mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        Assert.assertEquals("hello world world", result);
    }

    /**
     * define exception, test process
     */
    @SneakyThrows
    @Test(expected = IOException.class)
    public void processBehavior() {
        OutputStream outputStream = Mockito.mock(OutputStream.class);
        Mockito.doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }

    /**
     * define comparable comparable then return
     */
    @Test
    public void compareBehavior() {
        Comparable comparable = Mockito.mock(Comparable.class);
        Mockito.when(comparable.compareTo("hello")).thenReturn(1);
        Mockito.when(comparable.compareTo("world")).thenReturn(-1);
        Assert.assertEquals(comparable.compareTo("hello"), 1);
        Assert.assertEquals(comparable.compareTo("world"), -1);
        Assert.assertEquals(comparable.compareTo("cpu"), 0);
    }

    /**
     * define list behavior, test match、contain
     */
    @Test
    public void matchBehavior() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(1);
        Mockito.when(list.get(Mockito.intThat(new IntThat()))).thenReturn(0);
        Mockito.when(list.contains(Mockito.argThat(new IsValid()))).thenReturn(true);
        Assert.assertEquals(1, list.get(1));
        Assert.assertEquals(0, list.get(999));
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(999));
    }

    /**
     * define arguments, test comparator
     */
    @Test
    public void arguments() {
        Comparator comparator = Mockito.mock(Comparator.class);
        comparator.compare("hello", "world");
        Mockito.verify(comparator).compare(Mockito.anyString(), Mockito.eq("world"));
    }

    /**
     * test call times
     */
    @Test
    public void times() {
        List list = Mockito.mock(List.class);
        list.add(1);
        Mockito.verify(list).add(1);
        list.add(1);
        Mockito.verify(list, Mockito.times(2)).add(1);
    }

    /**
     * define exception for void return
     */
    @Test(expected = RuntimeException.class)
    public void exception() {
        List list = Mockito.mock(List.class);
        Mockito.doThrow(new RuntimeException()).when(list).clear();
        list.clear();
    }

    /**
     * define order
     */
    @Test
    public void order() {
        List list = Mockito.mock(List.class);
        List list2 = Mockito.mock(List.class);
        list.add(1);
        list2.add("hello");
        list.add(2);
        list2.add("world");
        InOrder order = Mockito.inOrder(list, list2);
        order.verify(list).add(1);
        order.verify(list2).add("hello");
        order.verify(list).add(2);
        order.verify(list2).add("world");

        // no behavior
        List list3 = Mockito.mock(List.class);
        List list4 = Mockito.mock(List.class);
        List list5 = Mockito.mock(List.class);
        list3.add(1);
        Mockito.verify(list3, Mockito.never()).add(2);
        Mockito.verifyNoMoreInteractions(list4, list5);

        // not be test behavior
        List list6 = Mockito.mock(List.class);
        list6.add(1);
        list6.add(2);
        Mockito.verify(list6).add(1);
        Mockito.verify(list6).add(2);
        Mockito.verifyNoMoreInteractions(list6);
    }

    /**
     * multiple call
     */
    @Test(expected = RuntimeException.class)
    public void multipleCall() {
        List list = Mockito.mock(List.class);
        list.add(1);
        Mockito.when(list.get(1)).thenReturn(1).thenReturn(0).thenReturn(-1)
            .thenThrow(new RuntimeException());
        Assert.assertEquals(1, list.get(1));
        Assert.assertEquals(0, list.get(1));
        Assert.assertEquals(-1, list.get(1));
        list.get(1);
    }

    /**
     * define return answer
     */
    @Test
    public void answerCall() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenAnswer((Answer<Integer>)invocation -> 0);
        Assert.assertEquals(0, list.get(-1));
    }

    /**
     * virtual call，return null
     */
    @Test
    public void mock() {
        List list = Mockito.mock(List.class);
        list.add(1);
        list.add(2);
        Assert.assertEquals(null, list.get(0));
        Assert.assertEquals(null, list.get(1));
    }

    /**
     * real call, return really value
     */
    @Test
    public void spy() {
        List list = new ArrayList();
        List spyList = Mockito.spy(list);
        spyList.add(1);
        spyList.add(2);
        Assert.assertEquals(1, spyList.get(0));
        Assert.assertEquals(2, spyList.get(1));
        // define
        Mockito.doReturn(999).when(spyList).get(999);
        Mockito.doReturn(100).when(spyList).size();
        Assert.assertEquals(999, spyList.get(999));
        Assert.assertEquals(100, spyList.size());
    }

    /**
     * default undefined value
     */
    @Test
    public void defaultUndefinedValue() {
        List list = Mockito.mock(List.class, invocation -> -1);
        Assert.assertEquals(-1, list.get(0));
    }

    /**
     * can visit the argument
     */
    @Test
    public void captor() {
        PersonDao personDao = Mockito.mock(PersonDao.class);
        PersonService personService = new PersonService(personDao);
        personService.update(1, "w");

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        Mockito.verify(personDao).update(captor.capture());
        Assert.assertEquals(1, captor.getValue().getId());
        Assert.assertEquals("w", captor.getValue().getName());
    }

    /**
     * change the return by doAnswer
     */
    @Test
    public void answer() {
        Subject subject = Mockito.mock(Subject.class);
        Mockito.doAnswer(invocation -> {
            String name = invocation.getMethod().getName();
            if("getInt".equals(name)){
                return 999;
            }
            return invocation.callRealMethod();
        }).when(subject).getInt();
        Assert.assertEquals(999, subject.getInt());
        Assert.assertEquals(0, subject.getInt2());
    }
}

class Subject{
    public int getInt(){
        return 1;
    }

    public int getInt2(){
        return 0;
    }
}

class IntThat implements ArgumentMatcher<Integer> {

    @Override
    public boolean matches(Integer argument) {
        return argument == 999;
    }
}


class IsValid implements ArgumentMatcher<Integer> {

    @Override
    public boolean matches(Integer argument) {
        return argument == 1 || argument == 2;
    }
}

class Person{

    private Integer id;

    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface PersonDao {
    public void update(Person person);
}

class PersonService{
    private PersonDao personDao;

    PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void update(int id, String name){
        personDao.update(new Person(id, name));
    }
}
