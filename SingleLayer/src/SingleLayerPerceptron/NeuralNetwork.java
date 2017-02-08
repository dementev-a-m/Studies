package SingleLayerPerceptron;
import java.util.*;
class LearnNeuralNetwork
{	
	private int a;	
	private double enters[];
	private double out;
	private double weights [] ;	
	private double dataOfLearn [] [];
			
	LearnNeuralNetwork(double dataOfLearn [] [], int a)
	{
		this.a=a;
		this.dataOfLearn = Arrays.copyOf(dataOfLearn, a);
		this.enters = new double[a];
		this.weights = new double[a];	
	}
	private void summator() {
		out = 0;
		for(int i=0;i<enters.length;i++) 
			out+=enters[i]*weights[i];
		if(out >0.1 )
			out=1;
		else out=0;
	}
	private void train() {
		double gError = 0;
		int it = 0;
		do {
			gError = 0;
			it++;
			for(int i = 0; i<dataOfLearn.length;i++){
				enters = Arrays.copyOf(dataOfLearn[i], dataOfLearn[i].length-1);
				summator();
				double error = dataOfLearn[i][dataOfLearn[i].length-1] - out;
				gError += Math.abs(error);
				for(int j = 0; j<enters.length;j++)
					weights[j] += 0.001*error*enters[j]; 
			}
		}while(gError!=0);
		System.out.println("Кол-во итераций обучения: "+ it);
	}
	public void test()
	{
		train();
		System.out.println("Результат: ");
		for(int i=0; i<dataOfLearn.length;i++){
			enters = Arrays.copyOf(dataOfLearn[i], dataOfLearn[i].length-1);
			summator();
			System.out.println(out);
		}
	}
}
public class NeuralNetwork {

	public static void main(String[] args) {
		double dataOfLearn [] []={
				{0,0,0},
				{0,1,0},
				{1,0,0},
				{1,1,1},
				{0,0,0},
				{0,1,0},
				{1,0,0},
				{1,1,1}
				
		};
		LearnNeuralNetwork testAnd	= new LearnNeuralNetwork(dataOfLearn,dataOfLearn.length);
		testAnd.test();
		double dataOfLearn1 [] []={
				{0,0,0},
				{0,1,1},
				{1,0,1},
				{1,1,1},
				{0,0,0},
				{0,1,1},
				{1,0,1},
				{1,1,1}
				
		};
		LearnNeuralNetwork testOR	= new LearnNeuralNetwork(dataOfLearn1,dataOfLearn1.length);
		testOR.test();


	}

}
