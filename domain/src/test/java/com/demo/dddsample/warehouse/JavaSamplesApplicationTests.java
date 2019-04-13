package com.demo.dddsample.warehouse;

import org.junit.Assert;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JavaSamplesApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        ValueObject value = new ValueObject("first");

        modify(value);

        Assert.assertEquals(value.getValue(), "first");
    }

    private void modify(ValueObject valueObject) {
        valueObject = new ValueObject();
        valueObject.setValue("second");
    }

    class ValueObject {
        private String value;

        public ValueObject() {
        }

        public ValueObject(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
