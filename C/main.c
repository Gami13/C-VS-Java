// COMPILE WITH: gcc main.c files.c sorts.c -O3 -o main.exe; ./main.exe

#include <stdio.h>
#include <stdlib.h>
#include "files.h"
#include "sorts.h"
#include "structInfo.h"

int main(void)
{
	char *text;
	int lineCount;
	getFile(&text, &lineCount, "C:\\numbers.txt");
	// printf("%s\n", text);
	printf("Line Count: %d\n", lineCount);
	int *numbers = (int *)malloc(lineCount * sizeof(int));
	NLSStringToIntArray(numbers, text);

	// create a copy of the array for each sort
	int *numbers2 = (int *)malloc(lineCount * sizeof(int));
	int *numbers3 = (int *)malloc(lineCount * sizeof(int));

	for (int i = 0; i < lineCount; i++)
	{
		numbers2[i] = numbers[i];
		numbers3[i] = numbers[i];
	}

	struct SortInfo insertion = insertionSort(numbers, lineCount);
	printf("Insertion Sort:\n");
	printf("Time: %lld ms\n", insertion.time);
	printf("Iterations: %lld\n", insertion.iterations);
	writeSortInfoToFile(insertion, "D:\\insertion.txt");

	struct SortInfo bubble = bubbleSort(numbers2, lineCount);
	printf("Bubble Sort:\n");
	printf("Time: %lld ms\n", bubble.time);
	printf("Iterations: %lld\n", bubble.iterations);
	writeSortInfoToFile(bubble, "D:\\bubble.txt");

	struct SortInfo quick = quickSort(numbers3, lineCount);
	printf("Quick Sort:\n");
	printf("Time: %lld ms\n", quick.time);
	printf("Swaps: %lld\n", quick.iterations);
	writeSortInfoToFile(quick, "D:\\quick.txt");

	return 0;
}
