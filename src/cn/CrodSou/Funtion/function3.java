package cn.CrodSou.Funtion;

public class function3 {
	public function3() {

	}

	double x1, x2, c1, c2, s1, s2, d, delta;

	public void setX1(double x1) {
		this.x1 = x1;
		// 参数成功从text1中传入
		System.out.println(x1);
	}

	public void setX2(double x2) {
		this.x2 = x2;
		System.out.println(x2);
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}

	public void setS1(double s1) {
		this.s1 = s1;
	}

	public void setS2(double s2) {
		this.s2 = s2;
	}

	public void setD(double d) {
		this.d = d;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	/*
	 * public double getS2() { return s2; } public double getX2() { return x2; }
	 * 
	 * 
	 * public double getX1() { System.out.println(x1); return x1; }
	 * 
	 * 
	 * public double getC1() { return c1; }
	 * 
	 * public double getC2() { return c2; }
	 * 
	 * public double getS1() { return s1; }
	 * 
	 * public double getD() { return d; }
	 * 
	 * public double getDelta() { return delta; }
	 */

	double K2(double x1, double x2, double U_Rmax_CN, double U_Rmin_CN, double U_Rmax_CA) {
		double K2 = (1 - x1 - x2 + x1 * x2) * (U_Rmax_CA - U_Rmax_CN)
				/ ((1 - x1 - 2 * x2 + 2 * x1 * x2) * (U_Rmax_CN - U_Rmin_CN)
						- (x1 + x2 - x1 * x2) * (U_Rmax_CA - U_Rmax_CN));
		return K2;
	}

	double B2(double x1, double x2, double delta, double U_Rmax_CN, double U_Rmin_CN, double U_Rmax_CA) {
		double B2 = (1 - delta) * (U_Rmax_CA - U_Rmax_CN)
				/ (delta * (1 - x1 - 2 * x2 + 2 * x1 * x2) * (U_Rmax_CN - U_Rmin_CN)
						- delta * (x1 + x2 - x1 * x2) * (U_Rmax_CA - U_Rmax_CN));
		return B2;
	}

	double K3(double x1, double x2, double U_Rmax_CN, double U_Rmin_CN) {
		double K3 = -(1 - x1 - x2 + x1 * x2) * (U_Rmax_CN) / ((x1 + x2 - x1 * x2) * U_Rmin_CN);
		return K3;
	}

	double B3(double x1, double x2, double delta) {
		double B3 = (delta - 1) / (delta * (x1 + x2 - x1 * x2));
		return B3;
	}

	// 得到alpha的值
	public double getAlpha() {
		V_Worker v = new V_Worker();
		function3 own = new function3();

		// 查看是否将set函数中的参数传入
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(d);
		System.out.println(delta);

		double Rmin = 0;
		// 代求最优值参数
		double Rmax = 1;
		double alpha = 0;
		double beta = 0;
		double Rmax_1 = 0;
		double alpha_1 = 0;
		double beta_1 = 0;
		double Rmax_2 = 0;
		double alpha_2 = 0;
		double beta_2 = 0;
		// ********************
		double c_ii;// 单次背叛原则
		double s_ii;// 单次背叛原则
		double c_iii;// 可持续性
		double s_iii;// 可持续性

		// **********************
		double U_Rmin_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmax);
		double U_Rmin_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmax);

		double K2;
		double B2;
		double K3;
		double B3;
		double K21;
		double K22;
		double B21;
		double B22;
		double K31;
		double K32;
		double B31;
		double B32;
		double v_requester;// requester的收益

		double v_requester_1 = 0;
		double v_requester_2 = 0;

		K21 = own.K2(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		B21 = own.B2(x1, x2, delta, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		K31 = own.K3(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1);
		B31 = own.B3(x1, x2, delta);

		K22 = own.K2(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		B22 = own.B2(x1, x2, delta, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		K32 = own.K3(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2);
		B32 = own.B3(x1, x2, delta);

		if (K21 > K22) {
			c_ii = c1;
			s_ii = s1;
		} else {
			c_ii = c2;
			s_ii = s2;
		}
		if (K31 > K32) {
			c_iii = c2;
			s_iii = s2;
		} else {
			c_iii = c1;
			s_iii = s1;
		}

		int i, j;

		double U_Rmin_CN_ii;
		double U_Rmax_CN_ii;
		double U_Rmin_CA_ii;
		double U_Rmax_CA_ii;
		double U_Rmin_CN_iii;
		double U_Rmax_CN_iii;
		double U_Rmin_CA_iii;
		double U_Rmax_CA_iii;

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((1 - B3) / K3 < 1) && (K2 < 0) && (K3 > 0))
					|| (((1 - B3) / K3 < 1) && (K2 > 0) && ((1 - B2) / K2 > (1 - B3) / K3) && (K3 > 0))) {
				alpha_1 = (1 - B3) / K3;
				beta_1 = 1;
				Rmax_1 = Rmax;
				v_requester_1 = (1 - x1 - x2 + x1 * x2) - (alpha_1 * (1 - x1 - x2 + x1 * x2) * Rmax_1)
						/ (beta_1 * (x1 + x2 - x1 * x2) + alpha_1 * (1 - x1 - x2 + x1 * x2));
				break;
			}
		}

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 < 0))
					|| (((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 > 0) && ((K2 + B2) <= (K3 + B3)))) {
				alpha_2 = 1;
				beta_2 = K3 + B3;
				Rmax_2 = Rmax;
				v_requester_2 = (1 - x1 - x2 + x1 * x2) - (alpha_2 * (1 - x1 - x2 + x1 * x2) * Rmax_2)
						/ (beta_2 * (x1 + x2 - x1 * x2) + alpha_2 * (1 - x1 - x2 + x1 * x2));
			}
		}
		if (v_requester_1 > v_requester_2) {
			Rmax = Rmax_1;
			alpha = alpha_1;
			beta = beta_1;
			v_requester = v_requester_1;
		} else {
			Rmax = Rmax_2;
			alpha = alpha_2;
			beta = beta_2;
			v_requester = v_requester_2;
		}
		System.out.println(alpha);
		return alpha;
	}

	// 得到beta的值
	public double getBeta() {
		V_Worker v = new V_Worker();
		function3 own = new function3();
		double Rmin = 0;
		// 代求最优值参数
		double Rmax = 1;
		double alpha = 0;
		double beta = 0;
		double Rmax_1 = 0;
		double alpha_1 = 0;
		double beta_1 = 0;
		double Rmax_2 = 0;
		double alpha_2 = 0;
		double beta_2 = 0;
		// ********************
		double c_ii;// 单次背叛原则
		double s_ii;// 单次背叛原则
		double c_iii;// 可持续性
		double s_iii;// 可持续性

		// **********************
		double U_Rmin_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmax);
		double U_Rmin_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmax);

		double K2;
		double B2;
		double K3;
		double B3;
		double K21;
		double K22;
		double B21;
		double B22;
		double K31;
		double K32;
		double B31;
		double B32;
		double v_requester;// requester的收益

		double v_requester_1 = 0;
		double v_requester_2 = 0;

		K21 = own.K2(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		B21 = own.B2(x1, x2, delta, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		K31 = own.K3(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1);
		B31 = own.B3(x1, x2, delta);

		K22 = own.K2(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		B22 = own.B2(x1, x2, delta, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		K32 = own.K3(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2);
		B32 = own.B3(x1, x2, delta);

		if (K21 > K22) {
			c_ii = c1;
			s_ii = s1;
		} else {
			c_ii = c2;
			s_ii = s2;
		}
		if (K31 > K32) {
			c_iii = c2;
			s_iii = s2;
		} else {
			c_iii = c1;
			s_iii = s1;
		}

		int i, j;

		double U_Rmin_CN_ii;
		double U_Rmax_CN_ii;
		double U_Rmin_CA_ii;
		double U_Rmax_CA_ii;
		double U_Rmin_CN_iii;
		double U_Rmax_CN_iii;
		double U_Rmin_CA_iii;
		double U_Rmax_CA_iii;

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((1 - B3) / K3 < 1) && (K2 < 0) && (K3 > 0))
					|| (((1 - B3) / K3 < 1) && (K2 > 0) && ((1 - B2) / K2 > (1 - B3) / K3) && (K3 > 0))) {
				alpha_1 = (1 - B3) / K3;
				beta_1 = 1;
				Rmax_1 = Rmax;
				v_requester_1 = (1 - x1 - x2 + x1 * x2) - (alpha_1 * (1 - x1 - x2 + x1 * x2) * Rmax_1)
						/ (beta_1 * (x1 + x2 - x1 * x2) + alpha_1 * (1 - x1 - x2 + x1 * x2));
				break;
			}
		}

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 < 0))
					|| (((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 > 0) && ((K2 + B2) <= (K3 + B3)))) {
				alpha_2 = 1;
				beta_2 = K3 + B3;
				Rmax_2 = Rmax;
				v_requester_2 = (1 - x1 - x2 + x1 * x2) - (alpha_2 * (1 - x1 - x2 + x1 * x2) * Rmax_2)
						/ (beta_2 * (x1 + x2 - x1 * x2) + alpha_2 * (1 - x1 - x2 + x1 * x2));
			}
		}
		if (v_requester_1 > v_requester_2) {
			Rmax = Rmax_1;
			alpha = alpha_1;
			beta = beta_1;
			v_requester = v_requester_1;
		} else {
			Rmax = Rmax_2;
			alpha = alpha_2;
			beta = beta_2;
			v_requester = v_requester_2;
		}
		System.out.println(beta);
		return beta;
	}

	// 得到Rmax的值
	public double getRmax() {
		V_Worker v = new V_Worker();
		function3 own = new function3();
		double Rmin = 0;
		// 代求最优值参数
		double Rmax = 1;
		double alpha = 0;
		double beta = 0;
		double Rmax_1 = 0;
		double alpha_1 = 0;
		double beta_1 = 0;
		double Rmax_2 = 0;
		double alpha_2 = 0;
		double beta_2 = 0;
		// ********************
		double c_ii;// 单次背叛原则
		double s_ii;// 单次背叛原则
		double c_iii;// 可持续性
		double s_iii;// 可持续性

		// **********************
		double U_Rmin_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmax);
		double U_Rmin_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmax);

		double K2;
		double B2;
		double K3;
		double B3;
		double K21;
		double K22;
		double B21;
		double B22;
		double K31;
		double K32;
		double B31;
		double B32;
		double v_requester;// requester的收益

		double v_requester_1 = 0;
		double v_requester_2 = 0;

		K21 = own.K2(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		B21 = own.B2(x1, x2, delta, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		K31 = own.K3(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1);
		B31 = own.B3(x1, x2, delta);

		K22 = own.K2(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		B22 = own.B2(x1, x2, delta, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		K32 = own.K3(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2);
		B32 = own.B3(x1, x2, delta);

		if (K21 > K22) {
			c_ii = c1;
			s_ii = s1;
		} else {
			c_ii = c2;
			s_ii = s2;
		}
		if (K31 > K32) {
			c_iii = c2;
			s_iii = s2;
		} else {
			c_iii = c1;
			s_iii = s1;
		}

		int i, j;

		double U_Rmin_CN_ii;
		double U_Rmax_CN_ii;
		double U_Rmin_CA_ii;
		double U_Rmax_CA_ii;
		double U_Rmin_CN_iii;
		double U_Rmax_CN_iii;
		double U_Rmin_CA_iii;
		double U_Rmax_CA_iii;

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((1 - B3) / K3 < 1) && (K2 < 0) && (K3 > 0))
					|| (((1 - B3) / K3 < 1) && (K2 > 0) && ((1 - B2) / K2 > (1 - B3) / K3) && (K3 > 0))) {
				alpha_1 = (1 - B3) / K3;
				beta_1 = 1;
				Rmax_1 = Rmax;
				v_requester_1 = (1 - x1 - x2 + x1 * x2) - (alpha_1 * (1 - x1 - x2 + x1 * x2) * Rmax_1)
						/ (beta_1 * (x1 + x2 - x1 * x2) + alpha_1 * (1 - x1 - x2 + x1 * x2));
				break;
			}
		}

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 < 0))
					|| (((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 > 0) && ((K2 + B2) <= (K3 + B3)))) {
				alpha_2 = 1;
				beta_2 = K3 + B3;
				Rmax_2 = Rmax;
				v_requester_2 = (1 - x1 - x2 + x1 * x2) - (alpha_2 * (1 - x1 - x2 + x1 * x2) * Rmax_2)
						/ (beta_2 * (x1 + x2 - x1 * x2) + alpha_2 * (1 - x1 - x2 + x1 * x2));
			}
		}
		if (v_requester_1 > v_requester_2) {
			Rmax = Rmax_1;
			alpha = alpha_1;
			beta = beta_1;
			v_requester = v_requester_1;
		} else {
			Rmax = Rmax_2;
			alpha = alpha_2;
			beta = beta_2;
			v_requester = v_requester_2;
		}
		System.out.println(Rmax);
		return Rmax;
	}

	// 得到v_requester的值
	public double getV_requester() {
		V_Worker v = new V_Worker();
		function3 own = new function3();
		double Rmin = 0;
		// 代求最优值参数
		double Rmax = 1;
		double alpha = 0;
		double beta = 0;
		double Rmax_1 = 0;
		double alpha_1 = 0;
		double beta_1 = 0;
		double Rmax_2 = 0;
		double alpha_2 = 0;
		double beta_2 = 0;
		// ********************
		double c_ii;// 单次背叛原则
		double s_ii;// 单次背叛原则
		double c_iii;// 可持续性
		double s_iii;// 可持续性

		// **********************
		double U_Rmin_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CN_1 = v.V_CN(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmin);
		double U_Rmax_CA_1 = v.V_CA(x1, x2, c1, s1, delta, Rmax);
		double U_Rmin_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CN_2 = v.V_CN(x1, x2, c2, s2, delta, Rmax);
		double U_Rmin_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmin);
		double U_Rmax_CA_2 = v.V_CA(x1, x2, c2, s2, delta, Rmax);

		double K2;
		double B2;
		double K3;
		double B3;
		double K21;
		double K22;
		double B21;
		double B22;
		double K31;
		double K32;
		double B31;
		double B32;
		double v_requester;// requester的收益

		double v_requester_1 = 0;
		double v_requester_2 = 0;

		K21 = own.K2(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		B21 = own.B2(x1, x2, delta, U_Rmax_CN_1, U_Rmin_CN_1, U_Rmax_CA_1);
		K31 = own.K3(x1, x2, U_Rmax_CN_1, U_Rmin_CN_1);
		B31 = own.B3(x1, x2, delta);

		K22 = own.K2(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		B22 = own.B2(x1, x2, delta, U_Rmax_CN_2, U_Rmin_CN_2, U_Rmax_CA_2);
		K32 = own.K3(x1, x2, U_Rmax_CN_2, U_Rmin_CN_2);
		B32 = own.B3(x1, x2, delta);

		if (K21 > K22) {
			c_ii = c1;
			s_ii = s1;
		} else {
			c_ii = c2;
			s_ii = s2;
		}
		if (K31 > K32) {
			c_iii = c2;
			s_iii = s2;
		} else {
			c_iii = c1;
			s_iii = s1;
		}

		int i, j;

		double U_Rmin_CN_ii;
		double U_Rmax_CN_ii;
		double U_Rmin_CA_ii;
		double U_Rmax_CA_ii;
		double U_Rmin_CN_iii;
		double U_Rmax_CN_iii;
		double U_Rmin_CA_iii;
		double U_Rmax_CA_iii;

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((1 - B3) / K3 < 1) && (K2 < 0) && (K3 > 0))
					|| (((1 - B3) / K3 < 1) && (K2 > 0) && ((1 - B2) / K2 > (1 - B3) / K3) && (K3 > 0))) {
				alpha_1 = (1 - B3) / K3;
				beta_1 = 1;
				Rmax_1 = Rmax;
				v_requester_1 = (1 - x1 - x2 + x1 * x2) - (alpha_1 * (1 - x1 - x2 + x1 * x2) * Rmax_1)
						/ (beta_1 * (x1 + x2 - x1 * x2) + alpha_1 * (1 - x1 - x2 + x1 * x2));
				break;
			}
		}

		Rmax = 0;
		for (i = 0; i < 10000; i++) {
			Rmax = Rmax + 0.0001;
			U_Rmin_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CN_ii = v.V_CN(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmin);
			U_Rmax_CA_ii = v.V_CA(x1, x2, c_ii, s_ii, delta, Rmax);
			U_Rmin_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CN_iii = v.V_CN(x1, x2, c_iii, s_iii, delta, Rmax);
			U_Rmin_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmin);
			U_Rmax_CA_iii = v.V_CA(x1, x2, c_iii, s_iii, delta, Rmax);
			K2 = own.K2(x1, x2, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			B2 = own.B2(x1, x2, delta, U_Rmax_CN_ii, U_Rmin_CN_ii, U_Rmax_CA_ii);
			K3 = own.K3(x1, x2, U_Rmax_CN_iii, U_Rmin_CN_iii);
			B3 = own.B3(x1, x2, delta);
			if ((((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 < 0))
					|| (((K3 + B3) < 1) && ((K3 + B3) > 0) && (K2 > 0) && ((K2 + B2) <= (K3 + B3)))) {
				alpha_2 = 1;
				beta_2 = K3 + B3;
				Rmax_2 = Rmax;
				v_requester_2 = (1 - x1 - x2 + x1 * x2) - (alpha_2 * (1 - x1 - x2 + x1 * x2) * Rmax_2)
						/ (beta_2 * (x1 + x2 - x1 * x2) + alpha_2 * (1 - x1 - x2 + x1 * x2));
			}
		}
		if (v_requester_1 > v_requester_2) {
			Rmax = Rmax_1;
			alpha = alpha_1;
			beta = beta_1;
			v_requester = v_requester_1;
		} else {
			Rmax = Rmax_2;
			alpha = alpha_2;
			beta = beta_2;
			v_requester = v_requester_2;
		}
		System.out.println(v_requester);
		return v_requester;
	}

	public static void main(String[] args) {
		function3 func = new function3();
		double a = func.getAlpha();
		System.out.println(a);
	}

}
