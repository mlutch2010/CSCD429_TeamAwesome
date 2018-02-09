import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class Data {
	int[] m1 = new int[2];int[] m2 = new int[2];int[] m3 = new int[2];int[] m4 = new int[2];int[] m5 = new int[2];int[] m6 = new int[2];
	int[] f1 = new int[2];int[] f2 = new int[2];int[] f3 = new int[2];int[] f4 = new int[2];int[] f5 = new int[2];int[] f6 = new int[2];
	int[] u1 = new int[2];int[] u2 = new int[2];int[] u3 = new int[2];int[] u4 = new int[2];int[] u5 = new int[2];int[] u6 = new int[2];
	int[] no = new int[2]; int dne;

	
	public Data()
	{
		
	}
	
	public void addDne(int dne)
	{
		this.dne = dne;
	}
	public void addData(int clicks, int impressions)
	{
		no[0] += clicks;
		no[1] += impressions;
	}
	

	public void addData(int gender, int age, int clicks, int impressions)
	{
		if(gender == 1)
		{
			if (age == 1)
			{
				m1[0] += clicks;
				m1[1] += impressions;
			}
			if (age == 2)
			{
				m2[0] += clicks;
				m2[1] += impressions;
			}
			if (age == 3)
			{
				m3[0] += clicks;
				m3[1] += impressions;
			}
			if (age == 4)
			{
				m4[0] += clicks;
				m4[1] += impressions;
			}
			if (age == 5)
			{
				m5[0] += clicks;
				m5[1] += impressions;
			}
			if (age == 6)
			{
				m6[0] += clicks;
				m6[1] += impressions;
			}
			
		}//end gender == 1
		
		if(gender == 2)
		{
			if (age == 1)
			{
				f1[0] += clicks;
				f1[1] += impressions;
			}
			if (age == 2)
			{
				f2[0] += clicks;
				f2[1] += impressions;
			}
			if (age == 3)
			{
				f3[0] += clicks;
				f3[1] += impressions;
			}
			if (age == 4)
			{
				f4[0] += clicks;
				f4[1] += impressions;
			}
			if (age == 5)
			{
				f5[0] += clicks;
				f5[1] += impressions;
			}
			if (age == 6)
			{
				f6[0] += clicks;
				f6[1] += impressions;
			}
			
		}//end gender == 2
		
		if(gender == 0)
		{
			if (age == 1)
			{
				u1[0] += clicks;
				u1[1] += impressions;
			}
			if (age == 2)
			{
				u2[0] += clicks;
				u2[1] += impressions;
			}
			if (age == 3)
			{
				u3[0] += clicks;
				u3[1] += impressions;
			}
			if (age == 4)
			{
				u4[0] += clicks;
				u4[1] += impressions;
			}
			if (age == 5)
			{
				u5[0] += clicks;
				u5[1] += impressions;
			}
			if (age == 6)
			{
				u6[0] += clicks;
				u6[1] += impressions;
			}
			
		}//end gender == 0
		
	}//end addDate()

	public void printToFile() throws IOException
	{
		DecimalFormat df = new DecimalFormat("#.#####");
		PrintWriter out = new PrintWriter(new FileWriter("MFUdata.txt")); 
		out.println("Male, age(0-12): " + m1[0] + " clicks " + m1[1] + " impressions " + df.format((double)m1[0]/(double)m1[1]) + "% clicked");
		out.println("Male, age(13-18): " + m2[0] + " clicks " + m2[1] + " impressions " + df.format((double)m2[0]/(double)m2[1]) + "% clicked");
		out.println("Male, age(19-24): " + m3[0] + " clicks " + m3[1] + " impressions " + df.format((double)m3[0]/(double)m3[1]) + "% clicked");
		out.println("Male, age(22-30): " + m4[0] + " clicks " + m4[1] + " impressions " + df.format((double)m4[0]/(double)m4[1]) + "% clicked");
		out.println("Male, age(31-40): " + m5[0] + " clicks " + m5[1] + " impressions " + df.format((double)m5[0]/(double)m5[1]) + "% clicked");
		out.println("Male, age(41+): " + m6[0] + " clicks " + m6[1] + " impressions " + df.format((double)m6[0]/(double)m6[1]) + "% clicked");
		out.println();
		out.println("Female, age(0-12): " + f1[0] + " clicks " + f1[1] + " impressions " + df.format((double)f1[0]/(double)f1[1]) + "% clicked");
		out.println("Female, age(13-18): " + f2[0] + " clicks " + f2[1] + " impressions " + df.format((double)f2[0]/(double)f2[1]) + "% clicked");
		out.println("Female, age(19-24): " + f3[0] + " clicks " + f3[1] + " impressions " + df.format((double)f3[0]/(double)f3[1]) + "% clicked");
		out.println("Female, age(22-30): " + f4[0] + " clicks " + f4[1] + " impressions " + df.format((double)f4[0]/(double)f4[1]) + "% clicked");
		out.println("Female, age(31-40): " + f5[0] + " clicks " + f5[1] + " impressions " + df.format((double)f5[0]/(double)f5[1]) + "% clicked");
		out.println("Female, age(41+): " + f6[0] + " clicks " + f6[1] + " impressions " + df.format((double)f6[0]/(double)f6[1]) + "% clicked");
		out.println();
		out.println("Unknown, age(0-12): " + u1[0] + " clicks " + u1[1] + " impressions " + df.format((double)u1[0]/(double)u1[1]) + "% clicked");
		out.println("Unknown, age(13-18): " + u2[0] + " clicks " + u2[1] + " impressions " + df.format((double)u2[0]/(double)u2[1]) + "% clicked");
		out.println("Unknown, age(19-24): " + u3[0] + " clicks " + u3[1] + " impressions " + df.format((double)u3[0]/(double)u3[1]) + "% clicked");
		out.println("Unknown, age(22-30): " + u4[0] + " clicks " + u4[1] + " impressions " + df.format((double)u4[0]/(double) u4[1]) + "% clicked");
		out.println("Unknown, age(31-40): " + u5[0] + " clicks " + u5[1] + " impressions " + df.format((double)u5[0]/(double)u5[1]) + "% clicked");
		out.println("Unknown, age(41+): " + u6[0] + " clicks " + u6[1] + " impressions " + df.format((double)u6[0]/(double)u6[1]) + "% clicked");
		out.println();
		out.println("No User info, " + no[0] + " clicks " + no[1] + " impressions " + df.format((double)no[0]/(double)no[1]) + "% clicked");
		out.println();
		out.println(dne + " lines not recorded because user doesn't exist");
		out.close();
	}





}
