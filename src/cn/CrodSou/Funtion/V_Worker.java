package cn.CrodSou.Funtion;

public class V_Worker {
	public double V_CN(double x1, double x2, double c, double s, double d, double R) {
		double A[] = { (1 - x1) * (1 - x2), (1 - x1) * x2, x1 * (1 - x2), x1 * x2 };
		double V[][] = { { R / 2 - c, -c - d, R - c, R - c - d },
				{ R - c - s, R / 2 - c - s - d, R - c - s, R - c - s - d }, { 0, -d, R / 2, -d },
				{ -s, -s - d, R - s, R / 2 - s - d } };
		double tempArray[] = new double[4];
		double tempNum = 0;
		double social_utility;
		int i, j;
		for (i = 0; i < 4; i++) {
			tempNum = 0;
			for (j = 0; j < 4; j++) {
				tempNum = tempNum + A[j] * V[j][i];
			}
			tempArray[i] = tempNum;
		}
		tempNum = 0;
		for (i = 0; i < 4; i++) {
			tempNum = tempNum + tempArray[i] * A[i];
		}
		social_utility = tempNum;
		return social_utility;
	}

	public double V_CA(double x1, double x2, double c, double s, double d, double R) {
		double B[] = { (1 - x1) * x2, (1 - x1) * (1 - x2), x1 * x2, x1 * (1 - x2) };
		double A[] = { (1 - x1) * (1 - x2), (1 - x1) * x2, x1 * (1 - x2), x1 * x2 };
		double V[][] = { { R / 2 - c, -c - d, R - c, R - c - d },
				{ R - c - s, R / 2 - c - s - d, R - c - s, R - c - s - d }, { 0, -d, R / 2, -d },
				{ -s, -s - d, R - s, R / 2 - s - d } };

		double tempArray[] = new double[4];
		double tempNum = 0;
		double social_utility;
		int i, j;
		for (i = 0; i < 4; i++) {
			tempNum = 0;
			for (j = 0; j < 4; j++) {
				tempNum = tempNum + B[j] * V[j][i];
			}
			tempArray[i] = tempNum;
		}
		tempNum = 0;
		for (i = 0; i < 4; i++) {
			tempNum = tempNum + tempArray[i] * A[i];
		}
		social_utility = tempNum;
		return social_utility;
	}
}
