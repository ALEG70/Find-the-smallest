import java.util.ArrayList;

class FindTheSmallest {

	public static void main(String [] args){
		ArrayList list = listHelper.numberToArrayList(12758);
		listHelper.getDiffNumbers(list, 3);
	}
    
}

class listHelper{
	
	
	public static void getDiffNumbers(ArrayList<Integer> list, int position){
		int min = listToInteger(list);
		int minTo = 0;
		int digit = list.get(list.size()-position);
		//System.out.println(list+" : "+digit);
		for (int i = 0; i < list.size(); i++){
			ArrayList<Integer> newList = new ArrayList<Integer>(list);
			newList.remove(list.size()-position);
			newList.add(i, digit);
			if (listToInteger(newList) < min) {min = listToInteger(newList); minTo = list.size() - i;}
			//System.out.println(listToInteger(newList) + " put "+digit+" to " + (list.size() - i) + " from " + (list.size()-position));
		}
		System.out.println("Min : " + min +" digit "+ digit + " from " + (list.size()-position) + " min to " + minTo);
	} 
	
	public static ArrayList<Integer> numberToArrayList(int num){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int number = num;
		for(;number%10 > 0;number = number/10){
			list.add(number%10);
		}
		return list;
	}
	
	public static int listToInteger(ArrayList<Integer> list){
		int result = 0;
		for(int i = 0, x = 1 ; i < list.size(); i++, x = x*10){
			//System.out.println(list.get(i) + " : " + x + " : " + result);
			result += list.get(i) * x;
		}
		return result;
	}
}
