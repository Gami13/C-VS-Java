#include <stdio.h>
#include <stdlib.h>
#include "files.h"
#include "sorts.h"
char *readFile(char *filepath)
{
	FILE *f = fopen(filepath, "rb");
	fseek(f, 0, SEEK_END);
	long fsize = ftell(f);
	fseek(f, 0, SEEK_SET); /* same as rewind(f); */

	char *text = malloc(fsize + 1);
	fread(text, fsize, 1, f);
	fclose(f);

	text[fsize] = 0;
	return text;
}
int countLines(char *filepath)
{
	int count = 0;
	char ch;
	FILE *f = fopen(filepath, "rb");

	while (!feof(f))
	{
		ch = fgetc(f);
		if (ch == '\n')
		{
			count++;
		}
	}
	return count;
}

void getFile(char **text, int *lineCount, char *filepath)
{
	*text = readFile(filepath);
	*lineCount = countLines(filepath);
}

void NLSStringToIntArray(int *numbers, char *text)
{
	int i = 0;
	int j = 0;
	int k = 0;
	char *temp = (char *)malloc(10 * sizeof(char));
	while (text[i] != '\0')
	{
		if (text[i] == '\n')
		{
			numbers[j] = atoi(temp);
			j++;
			k = 0;
			i++;
			continue;
		}
		temp[k] = text[i];
		k++;
		i++;
	}
}

void writeSortInfoToFile(struct SortInfo info, char *filepath)
{
	printf("Writing to file: %s\n", filepath);
	FILE *f = fopen(filepath, "w");
	fprintf(f, "Size: %d\n", info.size);
	fprintf(f, "Time: %lld ms\n", info.time);
	fprintf(f, "Iterations: %lld\n", info.iterations);
	fprintf(f, "Array: ");
	for (int i = 0; i < info.size; i++)
	{
		fprintf(f, "%d ", info.array[i]);
	}
	fclose(f);
}