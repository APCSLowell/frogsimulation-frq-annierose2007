public class FrogSimulation{
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops){
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;  //ignore this, it's used for testing
	}
	
	public boolean simulate(){ 
		int position = 0;
 		for (int count = 0; count < maxHops; count++){
 			position += hopDistance();
 			if (position >= goalDistance){
 				return true;
			}
 			else if (position < 0){
 				return false;
 			}
 		}
 		return false;
	}
	public double runSimulations(int num){ 
 		int countSuccess = 0;
 		for (int count = 0; count < num; count++){
 			if(simulate()){
 				countSuccess++;
 			}
		 }
		 return (double)countSuccess / num;
	}
}
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	
	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 
