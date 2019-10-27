
// my solution... not work. because String in java is immutable object...

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        boolean isFizzBuzz = false;
        String s = "";

        for(int i =1; i<=n; i++) {
            if (n%3 ==0) s += "Fizz"; isFizzBuzz = true;
            if (n%5 ==0) s += "Buzz"; isFizzBuzz = true;
            
            if(!isFizzBuzz) {
                s += Integer.toString(n);
                System.out.println(s);
            }
            list.add(s);
            s = new String("");
            isFizzBuzz = false;
        }
        return list;
    }
}

// another solution

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        for(int i=1; i<=n; i++) {
            if(i%3 ==0 && i%5 == 0){
                list.add("FizzBuzz");
            } else if(i%3 == 0){
                list.add("Fizz");
            } else if(i%5 == 0){
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}

// without % , because % is CPU consuming
// 3ms
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        int fizz = 0;
        int buzz = 0;
        int fizzbuzz = 0;
        for(int i=1; i<=n; i++) {
            fizz++;
            buzz++;
            fizzbuzz++;
            // fizzbuzz has higher priority
            if(fizzbuzz == 15){
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
                fizzbuzz = 0;
            } else if(fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else if(buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}