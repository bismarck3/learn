/**
 * @projectName learn
 * @package springboot.mock
 * @className springboot.mock.MockTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.mock;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static org.mockito.Mockito.*;


/**
 * MockTest
 *
 * @description mock
 * @author wangjing
 * @date 2020/9/24 11:08
 * @version v1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    /**
     * choose one of the runner or constructor
     */
    //    public MockTest() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Mock
    private List list;

    @Mock
    private ArticleDatabase articleDatabase;

    @InjectMocks
    private ArticleManager articleManager;

    @Test
    public void testAdd(){
       list.add(1);
       verify(list).add(1);
    }

    @Test
    public void testInjectMock() {
        articleManager.initialize();
        verify(articleDatabase).addListener(any(ArticleListener.class));
    }
}

class ArticleManager {

    private User user;

    private ArticleDatabase database;

    public ArticleManager(User user, ArticleDatabase database) {
        super();
        this.user = user;
        this.database = database;
    }

    public void initialize() {
        database.addListener(new ArticleListener());
    }
}

@NoArgsConstructor
@AllArgsConstructor
class User{
    @Getter
    @Setter
    private String id ;
    @Getter
    @Setter
    private String name;
}

class ArticleDatabase {

    private List<ArticleListener> articleListeners = new CopyOnWriteArrayList<>();

    public void addListener(ArticleListener articleListener) {
        articleListeners.add(articleListener);
    }
}

class ArticleListener{}

