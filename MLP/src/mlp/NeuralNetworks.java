package mlp;

import java.util.Arrays;

import javax.swing.JFrame;

class LearnNeuralNetwork
{	
	private double speedLearning;//скорость обучения
	private double hidden []; //скрытый слой
	private double inputs[]; //входные данные
	private double out ;// выходные
	public double weightsHidden [] [] ;	// веса входной - скрытый слой
	public double weightsOuter []; //веса скрытый - выходной слой
	private double dataOfLearn [] [];//массив данных
	LearnNeuralNetwork(double dataOfLearn [] [], int b)
	{
		this.dataOfLearn=dataOfLearn;
		this.speedLearning=0.01;
		this.inputs = new double[b];
		this.hidden =new double[inputs.length];
		this.weightsHidden = new double[hidden.length] [inputs.length];
		this.weightsOuter= new double[hidden.length];
	}	
	private void init()//задаем начальное значение весов
	{
		for (int i =0; i<weightsHidden.length;i++) {
			for(int j=0;j<weightsHidden[i].length;j++)
				weightsHidden[i][j]=Math.random()*0.7+0.1;
		}	
		for(int i=0;i<weightsOuter.length;i++)
			weightsOuter[i]=Math.random()*0.7+0.1;
	}
	private void summator() {
		out = 0;		
		for (int i =0; i<hidden.length;i++) {
			hidden[i]=0;
			for(int j=0;j<inputs.length;j++) 
					hidden[i]+=inputs[j]*weightsHidden[j][i];
					//hidden[i]=functionActivate(hidden[i]);
					if(hidden[i] >0.1)
						hidden[i]=1;
					else hidden[i]=0;// получение входных данных на скрытый слой
		}			
		for(int i=0;i<hidden.length;i++) 
			out=hidden[i]* weightsOuter[i];
		//out=functionActivate(out);
		if(out>0.1)
			out=1;
		else
			out=0;
	}
	double functionActivate(double x)
	{
		return 1/(1+Math.pow((Math.E),-x));
	}
	public void learning() { //Обучение нс
		init();
		double err[]= new double[hidden.length];
		double gError = 0;
		int it = 0;
		do {
			gError = 0;
			it++;			
			for(int p = 0; p<dataOfLearn.length;p++){
				inputs = Arrays.copyOf(dataOfLearn[p], dataOfLearn[p].length-1);
				summator();
				double error = dataOfLearn[p][dataOfLearn[p].length-1] - out;
				for(int j = 0; j<hidden.length;j++)
				{
					err[j]=error*weightsOuter[j];				
				}
				gError += Math.abs(error);		
				for(int q=0; q<inputs.length;q++)
					for(int j=0; j<hidden.length;j++)
						weightsHidden[j][q] += speedLearning*err[j]*inputs[q];
				for(int j=0; j<hidden.length;j++)
					weightsOuter[j] += speedLearning*error*hidden[j];
			}	
		}while(gError!=0.0);
		System.out.println("Кол-во итераций обучения: "+ it);
	}
	void test()
	{	
		learning();
		System.out.println("Результат: ");
		for(int i=0; i<dataOfLearn.length;i++){
			inputs = Arrays.copyOf(dataOfLearn[i], dataOfLearn[i].length-1);
			summator();
			System.out.println(out);
		}
	}
}
public class NeuralNetworks {	
	public static void main(String[] args) {
		double data1[][] ={
				{0,0,0},
				{0,1,0},
				{1,0,0},
				{1,1,1}
		};
		LearnNeuralNetwork Learn = new LearnNeuralNetwork(data1, data1[0].length-1);
		Learn.test();
		UserInterface mlp=new UserInterface("MLP");
		mlp.setSize(300, 300);
		mlp.setVisible(true);
		mlp.setResizable(false);
		mlp.setLocationRelativeTo(null);
		mlp.setDefaultCloseOperation(mlp.EXIT_ON_CLOSE);
		
	}

}
