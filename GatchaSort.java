//Mei-Ying Croddy
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.*;

public class GatchaSort
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File toSort = new File("D:\\Gatcha\\Spencer.txt");
		Scanner scanName = new Scanner(toSort);
		scanName.useDelimiter("\\s+[0-9]+\\s+ka\\s*");
		
		Scanner scanLine = new Scanner(toSort);
	
		ArrayList<Waifu> waifuList = new ArrayList<Waifu>();
		StringBuilder nameBuilder = new StringBuilder();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> lineList = new ArrayList<String>();
		ArrayList<Integer> kakeraList = new ArrayList<Integer>();
		
		
		while(scanName.hasNext())
		{
			String next = scanName.next();
			String line = scanLine.nextLine();
		
			if(!(next.equals(null)) && next.length() > 0)
			{
				nameList.add(next);
				
			}
	
			if(!(line.equals(null)) && line.length() > 0)
			{
				lineList.add(line);
			}
			
		}
		
		scanName.close();
		scanLine.close();
		
		for(int i = 0; i < lineList.size(); i++)
		{
			String line = lineList.get(i);
			String stripped = line.substring(0, line.length() -3);
			int index = stripped.length() - 1;
			int numSize = 0;
			String check = Character.toString(stripped.charAt(index));

				while(!(check.equals(" ")))
				{
					check = Character.toString(stripped.charAt(index));
					index--;
				   numSize++;
				   }
			index += 2;

			StringBuilder sb = new StringBuilder();
   
			   for(; index < stripped.length(); index++)
			   {
				 String num = Character.toString(stripped.charAt(index));
				 sb.append(num);
			   }
			String retName = sb.toString();

			kakeraList.add(Integer.parseInt(retName));
		}

		for(int i = 0; i < nameList.size(); i++)
		{
				if(nameList.get(i).length() > 0 && !(kakeraList.get(i).equals(null)));
				{
					Waifu waifu = new Waifu(nameList.get(i), kakeraList.get(i));
					waifuList.add(waifu);
				}
		}
		
		waifuList.sort((o1, o2) -> o1.getKakera().compareTo(o2.getKakera()));
		Collections.reverse(waifuList);
		
			for(int i = 0; i < nameList.size(); i++)
		{
			System.out.println(waifuList.get(i).getName() + " " + waifuList.get(i).getKakera());
		
		}
			System.out.println("-------------------------------------------");
			System.out.println();
		System.out.println("Sorted without kakera value:\n");
		for(int i = 0; i < nameList.size(); i++)
		{
			System.out.print(waifuList.get(i).getName() + " $ ");
		
		}
		
	}
}

class Waifu 
{
	private String name;
	private Integer kakera;

	Waifu(String n, Integer k)
	{
		if(!(n.equals(null)))
			name = n;
		if(k != null)
			kakera = k;
	}
	public String toString()
	{
		return name + " " + kakera;
	}
	
	public String getName()
	{
		return name;
	}
	public Integer getKakera()
	{
		return kakera;
	}
}