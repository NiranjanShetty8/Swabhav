package co.techlabs.foo;

public class Foo {

	public boolean result;

	@TestCase
	public boolean m1() {
		return true;
	}

	@TestCase
	public boolean m2() {
		return true;
	}

	@TestCase
	public boolean m3() {
		return false;
	}

	public boolean m4() {
		return true;
	}
}
