package cn.TwoSide.Funtion;

public class function {
	public function() {

	}

	double b, c, k, w, e, s;

	public void setB(double b) {
		this.b = b;
	}

	public void setC(double c) {
		this.c = c;
	}

	public void setK(double k) {
		this.k = k;
	}

	public void setW(double w) {
		this.w = w;
	}

	public void setE(double e) {
		this.e = e;
	}

	public void setS(double s) {
		this.s = s;
	}

	public static final double N = 0.01;
	double rs0, rs1;

	public double f1(double b0) { // 这里是代入b0来求b1
		double s0, s1, s2, s3, s4, max1, b1;
		for (b1 = 0.001; b1 < 1; b1 += 0.0001) {
			s0 = ((2 - k * b0) * (1 - 2 * k) * b + s * k * b1) / ((2 + k * b1 - k * b0) * (2 + w * k * (b1 - b0)));
			s1 = s / ((1 - 2 * k) * w * b0);
			s2 = (s * (2 - k * b0)) / (w * (1 - 2 * k) * b1 * (2 + k * b1 - k * b0));
			s3 = (((1 - k) * b - c) * (2 + k * b1 - k * b0) + s * (2 - k * b0))
					/ (w * (2 + k * b1 - k * b0) * (2 - k * b1));
			s4 = (k * b * b1 * (1 - k) + (s - c) * (2 + k * b1 - k * b0) + k * b * (2 - k * b0))
					/ (w * (2 + k * b1 - k * b0) * (2 - k * b0));

			max1 = Math.max(Math.max(Math.max(s1, s2), s3), s4);
			if (s0 > max1) // 这里写判断条件，满足条件则跳出
				break;
		}
		return b1;
	}

	public double f2(double b1) { // 这里是代入b1来求b0
		double s0, s1, s2, s3, s4, max1, b0;
		// double acc,b0,b1,obj0,obj1;
		for (b0 = 0.001; b0 < 1; b0 += 0.0001) {
			/*
			 * s0=( (2-k*b0)*b+s*k*b1 )/( (2+k*b1-k*b0)*(2+w*k*(b1-b0)) );
			 * s1=s/((1-2*k)*w*b0); s2=(s*(2-k*b0))/( w*(1-2*k)*b1*(2+k*b1-k*b0) ); s3=(
			 * (b-c)*(2+k*b1-k*b0)+s*(2-k*b0) )/( w*(2+k*b1-k*b0)*(2-k*b1) ); s4=(
			 * k*b*b1+(s-c)*(2+k*b1-k*b0) )/( w*(2+k*b1-k*b0)*(2-k*b0) );
			 */
			s0 = ((2 - k * b0) * (1 - 2 * k) * b + s * k * b1) / ((2 + k * b1 - k * b0) * (2 + w * k * (b1 - b0)));
			s1 = s / ((1 - 2 * k) * w * b0);
			s2 = (s * (2 - k * b0)) / (w * (1 - 2 * k) * b1 * (2 + k * b1 - k * b0));
			s3 = (((1 - k) * b - c) * (2 + k * b1 - k * b0) + s * (2 - k * b0))
					/ (w * (2 + k * b1 - k * b0) * (2 - k * b1));
			s4 = (k * b * b1 * (1 - k) + (s - c) * (2 + k * b1 - k * b0) + k * b * (2 - k * b0))
					/ (w * (2 + k * b1 - k * b0) * (2 - k * b0));

			max1 = Math.max(Math.max(Math.max(s1, s2), s3), s4);
			// printf("s0=%lf,max1=%lf\n",max1);

			if (s0 > max1) // 这里写判断条件，满足条件则跳出
				break;
		}
		return b0;
	}

	public double b0b1min0(double rs0, double rs1) {
		double b0 = 1, b1 = 1, obj0 = 0, obj1 = 0, obj2 = 0, obj3 = 0, rs2 = 0, rs3 = 0, newb0 = 0;
		b1 = f1(b0); // 更新b1 //固定b0,求b1
		b0 = f2(b1); // 更新b2
		int i;
		for (i = 0; i <= 100000; i++) {
			obj0 = 1 / (1 + (2 - k * b0) / (k * b1));
			b1 = f1(b0); // 更新b1
			b0 = f2(b1); // 更新b2
			obj1 = 1 / (1 + (2 - k * b0) / (k * b1));
			rs0 = b0;
			rs1 = b1;
			if ((obj0 - obj1) / obj1 <= e)
				break;
			// System.out.println("b0="+b0+"b1="+b1+"obj="+obj0);
		}
		// System.out.println("b0="+b0+"b1="+b1+"obj="+obj0);

		b0 = 1;
		b1 = 1;
		b0 = f2(b1); // 更新b2 //固定b1,求b0
		b1 = f1(b0); // 更新b1
		for (i = 0; i < 100000; i++) {
			obj2 = 1 / (1 + (2 - k * b0) / (k * b1));
			b0 = f2(b1); // 更新b2
			b1 = f1(b0); // 更新b1
			obj3 = 1 / (1 + (2 - k * b0) / (k * b1));
			rs2 = b0;
			rs3 = b1;
			if ((obj2 - obj3) / obj3 <= e)
				break;
			// printf("b0=%lf b1=%lf obj=%lf\n",b0,b1,obj1);
		}

		if (obj3 < obj1) { // 判断哪组b0,b1最小
			rs0 = rs2;
			rs1 = rs3;
		}

		if (rs0 <= 1 && rs1 <= 1)
			newb0 = b0;
		return newb0;
		// System.out.println("b0="+rs0+"b1="+rs1);
	}

	public double b0b1min1(double rs0, double rs1) {
		double b0 = 1, b1 = 1, obj0 = 0, obj1 = 0, obj2 = 0, obj3 = 0, rs2 = 0, rs3 = 0, newb1 = 0;
		b1 = f1(b0); // 更新b1 //固定b0,求b1
		b0 = f2(b1); // 更新b2
		int i;
		for (i = 0; i <= 100000; i++) {
			obj0 = 1 / (1 + (2 - k * b0) / (k * b1));
			b1 = f1(b0); // 更新b1
			b0 = f2(b1); // 更新b2
			obj1 = 1 / (1 + (2 - k * b0) / (k * b1));
			rs0 = b0;
			rs1 = b1;
			if ((obj0 - obj1) / obj1 <= e)
				break;
			// System.out.println("b0="+b0+"b1="+b1+"obj="+obj0);
		}
		// System.out.println("b0="+b0+"b1="+b1+"obj="+obj0);

		b0 = 1;
		b1 = 1;
		b0 = f2(b1); // 更新b2 //固定b1,求b0
		b1 = f1(b0); // 更新b1
		for (i = 0; i < 100000; i++) {
			obj2 = 1 / (1 + (2 - k * b0) / (k * b1));
			b0 = f2(b1); // 更新b2
			b1 = f1(b0); // 更新b1
			obj3 = 1 / (1 + (2 - k * b0) / (k * b1));
			rs2 = b0;
			rs3 = b1;
			if ((obj2 - obj3) / obj3 <= e)
				break;
			// printf("b0=%lf b1=%lf obj=%lf\n",b0,b1,obj1);
		}

		if (obj3 < obj1) { // 判断哪组b0,b1最小
			rs0 = rs2;
			rs1 = rs3;
		}

		if (rs0 <= 1 && rs1 <= 1)
			newb1 = b1;
		return newb1;
		// System.out.println("b0="+rs0+"b1="+rs1);
	}

	public double getb0() {
		double b0 = b0b1min0(rs0, rs1);
		return b0;
	}

	public double getb1() {
		// for(s=0;s<=1;s=s+0.005){
		double b1 = b0b1min1(rs0, rs1);
		return b1;
	}

	public double getup() {
		double up;
		double newup = 0;
		double eup;
		eup = ((1 - k) * b - c - s) * (1.0 / 2);
		up = (1.0 / 2)
				* (((k * rs1) / (2 + k * rs1 - k * rs0)) * ((k * rs1) / (2 + k * rs1 - k * rs0)) * ((1 - 2 * k) * b - s)
						- ((k * rs1) / (2 + k * rs1 - k * rs0)) * ((1 - 2 * k) * b - s) + (1 - k) * b - c - s);
		if (rs0 <= 1 && rs1 <= 1 && eup > 0 && up > 0)
			newup = up;
		return newup;
	}

	public static void main(String[] args) {
		function func = new function();
		System.out.print(func.getb0());
		System.out.print(func.getb1());
		System.out.print(func.getup());
	}
}
