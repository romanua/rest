import com.ix.restful.model.Response;
import com.ix.restful.util.ResponseComparator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
public class ResponseComparatorTest {

    private ResponseComparator comparator;

    @Before
    public void setUp() {
        comparator = new ResponseComparator();
    }

    @Test
    public void testNegativeComparing() {
        Response response1 = new Response("test", 4);
        Response response2 = new Response("longTest", 8);

        assertThat(comparator.compare(response1, response2), equalTo(-1));
    }

    @Test
    public void testEmptyStrings() {
        Response response1 = new Response("", 0);
        Response response2 = new Response("", 0);

        assertThat(comparator.compare(response1, response2), equalTo(0));
    }

    @Test
    public void testNullStrings() {
        Response response1 = new Response(null, 0);
        Response response2 = new Response(null, 0);

        assertThat(comparator.compare(response1, response2), equalTo(0));
    }

    @Test
    public void testPositiveComparing() {
        Response response1 = new Response("testtest", 8);
        Response response2 = new Response("test", 4);

        assertThat(comparator.compare(response1, response2), equalTo(1));
    }
}
