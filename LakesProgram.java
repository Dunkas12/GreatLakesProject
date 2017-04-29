package LakesPackage;

public class LakesProgram {
 
	private static double[] riverConcentrations;
	private static double[] lakeConcentrations;
	private final static String[] names = {"Superior", "Michigan", "Huron", "Erie", "Ontario"}; //This is also the master order 
	private final static double[] volumes = {2900, 1180, 850, 116, 393};
	private final static double[] riverFlowIn = {15, 38, 15, 17, 14};
	private final static double[] lakeFlowOut = {15, 38, 68, 85, 99}; 
	
		//Superior variables
		static double PsubIofS;
		static double Is;
		static double Ks;
		static double Cs;
		static double Fs;
		static double Vs;
		//Michigan variables
		static double PsubIofM;
		static double Im;
		static double Km;
		static double Cm;
		static double Fm;
		static double Vm;
		//Huron variables:
		static double Vh;
		static double PsubIofH;
		static double Ih;
		static double Kh;
		static double Fh;
		
		static double Ch;	
		//Erie variables:
		static double PsubIofE;
		static double Ie;
		static double Ke;
		static double Fe;
		static double Ve;
		
		static double Ce;

		//Ontario Variables:
		static double PsubIofO;
		static double Io;
		static double Ko;
		static double Fo;
		//static double Fo;
		
		static double Co;
		
		
		public static double[] getPollution(double[] riverConcentrationsIn, double[] lakeConcentrationsIn, double timeIn)
		{	
		// populates the class concentration arrays with data acquired from the user from the LakesUI class
			riverConcentrations = riverConcentrationsIn;
			lakeConcentrations = lakeConcentrationsIn;
			
		//creates an array to hold absolute pollution and percent pollution values
			double[] pollution = new double[names.length*2];
			
		//Assignes variables
			//Superior variables
			PsubIofS = volumes[0]*lakeConcentrations[0];
			Is = riverFlowIn[0]*riverConcentrations[0];
			Ks = volumes[0]/lakeFlowOut[0];
			Cs = (PsubIofS - Is*Ks);
			Fs = lakeFlowOut[0];
			Vs = volumes[0];
			//Michigan variables
			PsubIofM = volumes[1]*lakeConcentrations[1];
			Im = riverFlowIn[1]*riverConcentrations[1];
			Km = volumes[1]/lakeFlowOut[1];
			Cm =  (PsubIofM - Im*Km); 
			Fm = lakeFlowOut[1];
			Vm = volumes[1];
			//Huron variables:
			Vh = volumes[2]; 
			PsubIofH = volumes[2]*lakeConcentrations[2];
			Ih = riverFlowIn[2]*riverConcentrations[2];
			Kh = volumes[2]/lakeFlowOut[2]; 
			Fh = lakeFlowOut[2];
			
			Ch = (
					PsubIofH 
					- 	( Ih*Kh )
					- 	( Fs*Cs*( (Ks*Kh)/(Ks-Kh) ) + Is*Vs*Kh )/Vs
					- 	( Fm*Cm*( (Km*Kh)/(Km-Kh) ) + Im*Vm*Kh )/Vm
					);//end Ch		
			//Erie variables:
			PsubIofE = volumes[3]*lakeConcentrations[3];
			Ie = riverFlowIn[3]*riverConcentrations[3];
			Ke = volumes[3]/lakeFlowOut[3];
			Fe = lakeFlowOut[3] - riverFlowIn[3]; //flow from other lakes alone
			Ve = volumes[3];
			
			Ce =	(
					PsubIofE -
						(
							( Ie*Ke )
							+
							(	
								Fe*Ih*Kh*Ke 
								+
								(
										Fe*Fs*Cs*( (Ks*Kh)/(Ks-Kh) )*( (Ks*Ke)/(Ks-Ke) ) + Fe*Fs*Is*Ks*Kh*Ke		
								)/Vs
								+
								(
										Fe*Fm*Cm*( (Km*Kh)/(Km-Kh) )*( (Km*Ke)/(Km-Ke) ) + Fe*Fm*Im*Km*Kh*Ke
								)/Vm
								+
								Fe*Ch*( (Kh*Ke)/(Kh-Ke) )
							)/Vh
							
						)
					);//end Ce

			//Ontario Variables:
			PsubIofO = volumes[4]*lakeConcentrations[4];
			Io = riverFlowIn[4]*riverConcentrations[4];
			Ko = volumes[4]/lakeFlowOut[4];
			Fo = lakeFlowOut[4] - riverFlowIn[4]; //flow from other lakes alone
			
			Co =	(
					PsubIofO -
						(
							( Io*Ko )
							+
							(
								Fo*Ke*Ie*Ko + Fo*Ce*( (Ke*Ko)/(Ke-Ko) )
								+
								(
									Fo*Fe*Ih*Kh*Ke*Ko + Fo*Fe*Ch*( (Kh*Ke)/(Kh-Ke) )*( (Kh*Ko)/(Kh-Ko) )
									+
									(
										Fo*Fe*Fs*Is*Ks*Kh*Ke*Ko + Fo*Fe*Fs*Cs*( (Ks*Kh)/(Ks-Kh) )*( (Ks*Ke)/(Ks-Ke) )*( (Ks*Ko)/(Ks-Ko) )
									)/Vs
									+
									(
										Fo*Fe*Fm*Im*Km*Kh*Ke*Ko + Fo*Fe*Fm*Cm*( (Km*Kh)/(Km-Kh) )*( (Km*Ke)/(Km-Ke) )*( (Km*Ko)/(Km-Ko) )
									)/Vm
								)/Vh
								
							)/Ve
						)
					);//end Co
			
		//gets the pollution from the methods using timeIn an the class variables assigned above
			pollution[0] = getSuperiorPollution(timeIn);
			pollution[1] = getMichiganPollution(timeIn);
			pollution[2] = getHuronPollution(timeIn);
			pollution[3] = getEriePollution(timeIn);
			pollution[4] = getOntarioPollution(timeIn);	
			
			pollution[5] = getSuperiorPollutionPercent(timeIn);
			pollution[6] = getMichiganPollutionPercent(timeIn);
			pollution[7] = getHuronPollutionPercent(timeIn);
			pollution[8] = getEriePollutionPercent(timeIn);
			pollution[9] = getOntarioPollutionPercent(timeIn);	
			
			return pollution;
		}
	
	public static double getSuperiorPollution(double t) //Seprable equation
	{
		//Math.exp(x) = e^x
		return (Cs*Math.exp( (-t/Ks) ) + (Is*Ks)); 
	}
	
	public static double getMichiganPollution(double t) //Seprable equation
	{	
		return Cm*Math.exp(-t/Km) + Im*Km; 
	}
	
	public static double getHuronPollution(double t) 
	{	
		
		return		(	
							( Ih*Kh ) 
							+	( Fs*Cs*( (Ks*Kh)/(Ks-Kh) )*Math.exp(-t/Ks) + Is*Vs*Kh )/Vs
							+	( Fm*Cm*( (Km*Kh)/(Km-Kh) )*Math.exp(-t/Km) + Im*Vm*Kh )/Vm
							+	( Ch*Math.exp(-t/Kh) )
					);//end return 
	}
	
	public static double getEriePollution(double t) //
	{
		
		return	(
				( Ie*Ke + Ce*Math.exp(-t/Ke))
				+
				(
						Fe*Ih*Kh*Ke 
						+
						(
								Fe*Fs*Cs*( (Ks*Kh)/(Ks-Kh) )*( (Ks*Ke)/(Ks-Ke) )*Math.exp(-t/Ks) + Fe*Fs*Is*Ks*Kh*Ke
						)/Vs
						+
						(
								Fe*Fm*Cm*( (Km*Kh)/(Km-Kh) )*( (Km*Ke)/(Km-Ke) )*Math.exp(-t/Km) + Fe*Fm*Im*Km*Kh*Ke
						)/Vm
						+
						Fe*Ch*( (Kh*Ke)/(Kh-Ke) )*Math.exp(-t/Kh)
				)/Vh
				
			);
	}
	
	public static double getOntarioPollution(double t) //
	{

		return	(
				( Io*Ko + Co*Math.exp(-t/Ko))
				+
				(
					Fo*Ke*Ie*Ko + Fo*Ce*( (Ke*Ko)/(Ke-Ko) )*Math.exp(-t/Ke)
					+
					(
						Fo*Fe*Ih*Kh*Ke*Ko + Fo*Fe*Ch*( (Kh*Ke)/(Kh-Ke) )*( (Kh*Ko)/(Kh-Ko) )*Math.exp(-t/Kh)
						+
						(
							Fo*Fe*Fs*Is*Ks*Kh*Ke*Ko + Fo*Fe*Fs*Cs*( (Ks*Kh)/(Ks-Kh) )*( (Ks*Ke)/(Ks-Ke) )*( (Ks*Ko)/(Ks-Ko) )*Math.exp(-t/Ks)
						)/Vs
						+
						(
							Fo*Fe*Fm*Im*Km*Kh*Ke*Ko + Fo*Fe*Fm*Cm*( (Km*Kh)/(Km-Kh) )*( (Km*Ke)/(Km-Ke) )*( (Km*Ko)/(Km-Ko) )*Math.exp(-t/Km)
						)/Vm
					)/Vh
					
				)/Ve
			);//end return
	}
	
	public static double getSuperiorPollutionPercent(double t)
	{
		return getSuperiorPollution(t)/volumes[0] *100; //*100 converts abs to percent
	}
	
	public static double getMichiganPollutionPercent(double t)
	{
		return getMichiganPollution(t)/volumes[1] *100; //*100 converts abs to percent
	}

	public static double getHuronPollutionPercent(double t)
	{
		return getHuronPollution(t)/volumes[2] *100; //*100 converts abs to percent
	}
	
	public static double getEriePollutionPercent(double t)
	{
		return getEriePollution(t)/volumes[3] *100; //*100 converts abs to percent
	}
	
	public static double getOntarioPollutionPercent(double t)
	{
		return getOntarioPollution(t)/volumes[4] *100; //*100 converts abs to percent
	}
	
}
