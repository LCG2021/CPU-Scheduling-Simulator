#include <stdio.h>
void main()
{
	int n, i, j, p[10], a[10], b[10], c[20], wt[20], tat[20], temp, temp1, temp2;
	printf("Enter the number of process:");
	scanf("%d", &n);
	printf("Enter the names of processes:");
	for (i = 0; i < n; i++)
		scanf("%d", &p[i]);
	printf("Enter the Arrival Times:");
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
	printf("Enter the Burst Times:");
	for (i = 0; i < n; i++)
		scanf("%d", &b[i]);
	for (i = 0; i < n; i++)
	{
		for (j = i; j < n; j++)
		{
			if (b[i] >= b[j])
			{
				temp = b[i];
				b[i] = b[j];
				b[j] = temp;
				temp1 = p[i];
				p[i] = p[j];
				p[j] = temp1;
				temp2 = a[i];
				a[i] = a[j];
				a[j] = temp2;
			}
		}
	}
	c[0] = a[0] + b[0];
	for (i = 1; i < n; i++) {
		c[i] = c[i - 1] + b[i];
	}
	printf("The completion time for process are:");
	for (i = 0; i < n; i++) {
		printf(" %d", c[i]);
	}
	printf("\nThe TAT time for process are:");
	for (i = 0; i < n; i++) {
		tat[i] = c[i] - a[i];
		printf(" %d", tat[i]);
	}
	printf("\nThe Waiting time for process are:");
	for (i = 0; i < n; i++) {
		wt[i] = tat[i] - b[i];
		printf(" %d", wt[i]);
	}
	float atat, awt;
	printf("\nThe Average TAT time for process is:");
	for (i = 0; i < n; i++) {
		atat = atat + tat[i];
	}
	printf("%f", atat / n);
	printf("\nThe Average Waiting time for process is:");
	for (i = 0; i < n; i++) {
		awt = awt + wt[i];
	}
	printf("%f\n", awt / n);
	printf("\n\t\t\t***********GANTT CHART************\n");
	printf("\t\tProces\tAT\tBT\tCT\tTAT\tWT");
	for (i = 0; i < n; i++) {
		printf("\n\t\t%d\t%d\t%d\t%d\t%d\t%d", p[i], a[i], b[i], c[i], tat[i], wt[i]);
	}
	printf("\n");
}

