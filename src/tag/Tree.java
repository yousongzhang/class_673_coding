package tag;

public class Tree {
	private int[] data; 
	private int[] distance;
	private int[] prev;
	private int maxDistance;
	private int maxIndex;
	
	public Tree(int[] a){
         data = a;
         distance = new int[a.length];	
         prev = new int[a.length];
         this.findMaxDistance();
	}
	
	public void printMax(){
		System.out.println("Tree Print : ");
		printTree();
		System.out.println("max sum is : " + maxDistance);
		int index = maxIndex;
		System.out.println("this path is :");
		PrintPrev(maxIndex);
					
	}
	
	public void printTree(){
		int level = 0;
		
		while(haveLevel(level)){
			printTreeLevel(level);
			level++;
		}
		
		
	}
	
	public boolean haveLevel(int level){
		if(beginOfLevel(level) < data.length){
			return true;
		}else{
			return false;
		}
	}
	
	public void printTreeLevel(int level){
		int begin = beginOfLevel(level);
		int end = endOfLevel(level);
		if(end > data.length) end = data.length - 1 ;
		System.out.print("level : " + level + "  ");
		for(int i = begin ; i <= end ; i++){
			System.out.print(" ["+i+"] " + data[i] +" s["+distance[i]+"]" +"   " );
		}
		System.out.println(); 
	}
	
	public void PrintPrev(int index){
		if(index == 0){
			System.out.println("Node[" + index + "] value " + data[index] + " sum "+ distance[index]);
		}else{
			int indexPrev = prev[index];
			PrintPrev(indexPrev);
			System.out.println("Node[" + index + "] value " + data[index] + " sum "+ distance[index]);

		}
		
	}
	
	/**
	 * index begin with 1 
	 */
	public void findMaxDistance(){
		distance[0] = data[0];
		maxDistance = data[0];
		maxIndex = 0;
		
		for(int i = 1; i< data.length; i++){
			int level = getLevel(i);
			int begin = beginOfLevel(level);
			int end = endOfLevel(level);
			if(i == begin){
				int parent = beginOfLevel(level -1);
				distance[i] = data[i] + distance[parent];
				prev[i] = parent;
			}else if (i == end){
				int parent = endOfLevel(level -1);
				distance[i] = data[i] + distance[parent];	
				prev[i] = parent;
			}else{
				int parentBegin = beginOfLevel(level -1);
				int offset = i - begin;
				int parent = parentBegin + offset;
				int leftDistance = distance[parent - 1] + data[i];
				int rightDistance = distance[parent] + data[i];
				
				if(leftDistance >= rightDistance){
					distance[i] = leftDistance;
					prev[i] = parent - 1;
				}else{
					distance[i] = rightDistance;
					prev[i] = parent;
				}
				
			}
			
			// check max
			if(maxDistance < distance[i]){
				maxIndex = i;
				maxDistance = distance[i];
			}
		}
		
		
		
	}
	
	// 
	public int beginOfLevel(int level){  //level begin at 0 
		int prev = level* (level + 1)/2;
		return prev;
	}
	
	// 
	public int endOfLevel(int level){  //level begin at 0 
		level++;
		int end = level* (level + 1)/2;
		return end-1;
	}
	
	public int getLevel(int index){
		int level = 0;
		while(index > endOfLevel(level)){
			level++;
		}
			
		return level;
	}

}
