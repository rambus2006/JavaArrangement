package _16Generic;

public class Triple <F,S,T>{
        private F first;
        private S second;
        private T third;


        public Triple(F first,S second,T third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
        public T getThird() {
            return third;
        }
        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
}

