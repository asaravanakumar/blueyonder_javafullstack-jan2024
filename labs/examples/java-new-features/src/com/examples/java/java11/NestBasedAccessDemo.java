package com.examples.java.java11;

public class NestBasedAccessDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerPublic();


//        Outer.Inner inner = new Outer.Inner();
//        inner.innerPublic();

    }
}

class Outer {

    public void outerPublic() {
        System.out.println("Outer Public Method");
    }

    private void outerPrivate() {
        System.out.println("Outer Private Method");
    }

    class Inner {
        public void innerPublic() {
            System.out.println("Inner Public Method");
            outerPrivate();
        }
    }
}
