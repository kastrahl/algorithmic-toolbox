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
