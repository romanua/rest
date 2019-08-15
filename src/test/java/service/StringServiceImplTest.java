package service;

import com.ix.restful.model.MaxString;
import com.ix.restful.model.Response;
import com.ix.restful.model.Strings;
import com.ix.restful.service.StringsService;
import com.ix.restful.service.StringsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StringsServiceImpl.class)
public class StringServiceImplTest {

    @Autowired
    StringsService service;

    @Test
    public void testProcess() {
        Strings strings = new Strings();
        strings.setStrings(Arrays.asList("a1", "str", "mystr"));

        assertThat(service.process(strings), equalTo(strings));
    }

    @Test
    public void testMaxWord() {
        Strings strings = new Strings();
        strings.setStrings(Arrays.asList("a1", "str", "mystr"));

        List<Response> response = new ArrayList<>();
        response.add(new Response("mystr", 5));
        response.add(new Response("str", 3));
        response.add(new Response("a1", 2));

        MaxString maxString = new MaxString();
        maxString.setResponse(response);

        assertThat(service.maxWord(strings).equals(maxString), equalTo(true));
    }
}
