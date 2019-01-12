import java.util.ArrayList;
import java.util.Collections;

class FindTheSmallest {

	public static void main(String [] args){
		ArrayList<Integer> list = listHelper.numberToArrayList(100000653780006L);
		execute(list);
	}
    
	public static void execute(ArrayList<Integer> list){
		int size = list.size();
		Long[] result = {listHelper.listToInteger(list),0L,0L};
		for (int i = 0; i < size; i++){
			Long[] arr = listHelper.getDiffNumbers(list, i);
			if (arr[0] != null)
			if (arr[0] < result[0] || (arr[0] == result[0] && arr[1] < result[1]) || (arr[0] == result[0] && arr[1] == result[1] && arr[2] < result[2])) 
			{result = arr;}	
		}
		System.out.println("Minimal number from " +listHelper.listToInteger(list) +  " is " + result[0] + " get " + list.get(result[1].intValue()) + " and set to " + result[2] + " position");
	}
	
}


class listHelper{
	
	public static Long[] getDiffNumbers(ArrayList<Integer> list, int position){ //Magic
		Long[] result = new Long[3];
		long min = listToInteger(list);
		int digit = list.get(position);
		for (int i = 0; i < list.size(); i++){
			ArrayList<Integer> newList = new ArrayList<Integer>(list);
			newList.remove(position);// Delete from old place
			newList.add(i, digit);// Set to new place 
			if (listToInteger(newList) < min) {// Make new int & compare with smallest one
				min = listToInteger(newList);
				result[0] = min;
				result[1] = (long)position;
				result[2] = (long)i;
				//System.out.println("Number from to ");
				//System.out.println(result[0] + " " + result[1] + " " + result[2]);
			}
		}
		return result;
	} 
	
	public static ArrayList<Integer> numberToArrayList(long num){//Make List from int
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(num > 0){
			list.add((int)(num%10));
			num = num/10;
		}
		Collections.reverse(list);
		
		System.out.println("Collection is: ");
		System.out.println(list);
		
		return list;
	}

	public static long listToInteger(ArrayList<Integer> list){//Make int from List
		long result = 0;
		long x = 1;
		for(int i = list.size() - 1; i >= 0; i--, x = x*10){
			//System.out.println("(x)"+x+" * "+"(digit)"+list.get(i)+" = "+(long)list.get(i) * x);
			result += (long)list.get(i) * x;
		}
		
		return result;
	}
}
