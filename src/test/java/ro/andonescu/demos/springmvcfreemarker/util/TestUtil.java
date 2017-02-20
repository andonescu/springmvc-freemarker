package ro.andonescu.demos.springmvcfreemarker.util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

public class TestUtil {

    private TestUtil() {

    }

    public static MockHttpServletRequestBuilder postWithData(String url, Object formData)
            throws IllegalArgumentException, IllegalAccessException {
        MockHttpServletRequestBuilder post = post(url);

        Class<?> clazz = formData.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().equals(String.class) || field.getType().equals(Boolean.class)) {
                post = post.param(field.getName(), String.valueOf(field.get(formData)));
            } else if (field.getType().equals(Date.class)) {
                Date date = (Date) field.get(formData);
                if (date != null) {
                    post = post.param(field.getName(), DateUtil.getFormat((Date) field.get(formData)));
                }
            }
        }

        return post;
    }

    public static MockMultipartHttpServletRequestBuilder fileUploadReq(String url, List<MockMultipartFile> files) {
        MockMultipartHttpServletRequestBuilder mock = fileUpload(url);
        files.forEach(file -> mock.file(file));

        return mock;
    }

}
