import java.util.*;
public class Main
{
    private static List<Integer> optimalPoints(Segment[] mysegment)  //return type is a list for easier point countin
    {
       
        List<Integer> points = new ArrayList<Integer>();
        
        int n = mysegment.length;
        int s = 0;
        while (s < n) 
        {
        	Segment tempsegment = mysegment[s];
        	int p = s; 
        	while (p < n && mysegment[p].start <= tempsegment.end)  //going through segments having start before end of firt segment
        		p++;                                                //iterating to next segment's start AS END POINTS ARE ALREADY SORTED NO NEED TO CHECK 
            points.add(tempsegment.end);                              //STORING end points with no prev segment
        	s = p;                                                  //going to next end point
        }
        
        
    /*  for (int i = 0; i < segments.length; i++) 
        {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
        
        return points;
    }

    private static class Segment 
    {
        int start, end;

        Segment(int start, int end) 
        {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Segment[] mysegment = new Segment[n];
        for (int i = 0; i < n; i++) 
        {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            mysegment[i] = new Segment(start, end);
        }
        
        Main ob = new Main(); 
        ob.sort(mysegment, 0, mysegment.length - 1);
        
        List<Integer> points = optimalPoints(mysegment);  //using list for easier return of points. using array has extra 0 0 as return
        System.out.println(points.size());
        for (int point : points) 
        {
            System.out.print(point + " ");
        }
    }
    
    void merge(Segment[] mysegment, int l, int m, int r) 
	{ 
		int n1 = m - l + 1; 
		int n2 = r - m; 
		Segment L[] = new Segment[n1]; 
		Segment R[] = new Segment[n2]; 

		for (int i = 0; i < n1; ++i) 
			L[i] = mysegment [l + i]; 
		for (int j = 0; j < n2; ++j) 
			R[j] = mysegment [m + 1 + j]; 

		int i = 0, j = 0; 
		int k = l; 
		while (i < n1 && j < n2) 
        { 
			if (L[i].end <= R[j].end) 
            { 
				mysegment[k] = L[i]; 
				i++; 
			} 
			else 
            { 
				mysegment[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 
		while (i < n1) 
        { 
			mysegment[k] = L[i]; 
			i++; 
			k++; 
		} 
		while (j < n2) 
        { 
			mysegment[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 
	
	void sort(Segment[] mysegment, int l, int r) 
	{ 
		if (l < r) 
        { 
			int m = (l + r) / 2; 
			sort(mysegment, l, m); 
			sort(mysegment, m + 1, r); 
			merge(mysegment, l, m, r); 
		} 
	}
}
