package co.techlabs.foo;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public
@interface TestCase {
}
