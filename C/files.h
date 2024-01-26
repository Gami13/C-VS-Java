#include "structInfo.h"
extern char *readFile(char *filepath);
extern int countLines(char *filepath);
extern void getFile(char **text, int *lineCount, char *filepath);
extern void NLSStringToIntArray(int *numbers, char *text);
extern void writeSortInfoToFile(struct SortInfo info, char *filepath);
