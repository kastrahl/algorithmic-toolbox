// C++ program for 3-way quick sort
#include <bits/stdc++.h>
using namespace std;

void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}
void printarr(int a[], int n)                                   // A utility function to print an array
{
	for (int i = 0; i < n; ++i)
		printf("%d ", a[i]);
	printf("\n");
}
/* This function partitions a[] in three parts
a) a[l..i] contains all elements smaller than pivot
b) a[i+1..j-1] contains all occurrences of pivot
c) a[j..r] contains all elements greater than pivot */
void partition(int a[], int low, int high, int& i, int& j)      // It uses Dutch National Flag Algorithm
{
	// To handle 2 elements
	if (high - low <= 1) {
		if (a[high] < a[low])
			swap(&a[high], &a[low]);
		i = low;
		j = high;
		return;
	}

	int mid = low;
	int pivot = a[high];
	while (mid <= high) {
		if (a[mid] < pivot)
			swap(&a[low++], &a[mid++]);
		else if (a[mid] == pivot)
			mid++;
		else if (a[mid] > pivot)
			swap(&a[mid], &a[high--]);
	}
	i = low - 1;                                       // update i and j
	j = mid;                                           // or high+1
}
void quicksort(int a[], int low, int high)             // 3-way partition based quick sort
{
	if (low >= high)                                   // 1 or 0 elements
		return;

	int i, j;
	partition(a, low, high, i, j);                      // Note that i and j are passed as reference

	quicksort(a, low, i);                               // Recur two halves
	quicksort(a, j, high);
}

int main()                                      // Driver Code
{
	int a[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
	int size = sizeof(a) / sizeof(int);
    printarr(a, size);                          // Function Call
	quicksort(a, 0, size - 1);
	printarr(a, size);
	return 0;
}
