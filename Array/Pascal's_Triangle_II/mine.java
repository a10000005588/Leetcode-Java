class Solution {
  public List<Integer> getRow(int rowIndex) {
      List<Integer> previous = new ArrayList<Integer>();
      List<Integer> current = new ArrayList<Integer>();
      for(int i=0; i<=rowIndex; i++) {
          if(i==0) {
              current.add(1);
          } else if(i==1) {
              current.add(1);
              current.add(1);
          } else {
              current.add(1);
              for(int j=1; j<i; j++) {
                  current.add(previous.get(j)+previous.get(j-1));
              }
              current.add(1);
          }
          previous=current;
          if(i<rowIndex) {
              current= new ArrayList<Integer>();
          }
      }
      return current;
  }
}