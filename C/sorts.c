#include <stdio.h>
#include <stdlib.h>
#include "sorts.h"
#include <time.h>

struct SortInfo bubbleSort(int *array, int size)
{
	struct SortInfo info;
	info.size = size;
	info.time = 0;
	info.iterations = 0;
	int temp;
	clock_t start = clock();
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < (size - i - 1); j++)
		{
			info.iterations++;
			if (array[j] > array[j + 1])
			{
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	}
	clock_t end = clock();
	info.array = array;

	info.time = end - start / (CLOCKS_PER_SEC / 1000);
	return info;
}

struct SortInfo insertionSort(int *array, int size)
{
	struct SortInfo info;
	info.size = size;
	info.time = 0;
	info.iterations = 0;
	int temp;
	clock_t start = clock();
	for (int i = 1; i < size; i++)
	{
		temp = array[i];
		int j = i - 1;
		while (j >= 0 && array[j] > temp)
		{
			info.iterations++;
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = temp;
	}
	clock_t end = clock();
	info.array = array;

	info.time = end - start / (CLOCKS_PER_SEC / 1000);
	return info;
}
int quicksortSwaps = 0;
void swap(int *a, int *b)
{
	int t = *a;
	*a = *b;
	*b = t;
	quicksortSwaps++;
}
int partition(int array[], int low, int high)
{

	int pivot = array[high];
	int i = (low - 1);
	for (int j = low; j < high; j++)
	{
		if (array[j] <= pivot)
		{

			i++;

			swap(&array[i], &array[j]);
		}
	}

	swap(&array[i + 1], &array[high]);

	return (i + 1);
}
void quickSortA(int array[], int low, int high)
{
	if (low < high)
	{

		int pi = partition(array, low, high);

		quickSortA(array, low, pi - 1);

		quickSortA(array, pi + 1, high);
	}
}
struct SortInfo quickSort(int *array, int size)
{
	struct SortInfo info;
	info.size = size;
	info.time = 0;
	info.iterations = 0;
	clock_t start = clock();
	quickSortA(array, 0, size - 1);

	clock_t end = clock();
	info.array = array;
	info.iterations = quicksortSwaps;
	quicksortSwaps = 0;
	info.time = end - start / (CLOCKS_PER_SEC / 1000);
	return info;
}