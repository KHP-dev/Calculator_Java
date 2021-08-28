package com.example.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtShow;

    TextView btnPlus;
    TextView btnMinus;
    TextView btnMul;
    TextView btnDiv;

    boolean chonDau;
    boolean minus;
    String txtCache;
    int maxLen;

    ArrayList<Double> so;
    ArrayList<String> dau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minus = false;
        chonDau = false;
        txtCache = "0";
        maxLen = 9;

        so = new ArrayList<>();
        dau = new ArrayList<>();

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        txtShow = findViewById(R.id.txtShow);

    }

    public void runTest() {
        int i = 0;
        while (i < dau.size()){
            if (dau.get(i).equals("x") || dau.get(i).equals("/")) {

                if (dau.get(i).equals("x")) {
                    double kq = so.get(i) * so.get(i + 1);
                    so.remove(i+1);
                    so.set(i, kq);
                }
                else {
                    double kq = so.get(i) / so.get(i + 1);
                    so.remove(i+1);
                    so.set(i, kq);
                }
                dau.remove(i);
            }
            else i++;
        }
        i = 0;
        while (i < dau.size()) {
            if (dau.get(i).equals("+")) {
                double kq = so.get(i) + so.get(i + 1);
                so.remove(i+1);
                so.set(i, kq);
            }
            else {
                double kq = so.get(i) - so.get(i + 1);
                so.remove(i+1);
                so.set(i, kq);
            }
            dau.remove(i);
        }

        double rs = so.get(so.size() - 1);
        if (rs < 0) {
            double con = SimpleCalculation.sub(0, rs);
            txtCache = Double.toString(con);
            minus = true;
        }
        else {
            txtCache = Double.toString(rs);
            minus = false;
        }
        so.clear();
        dau.clear();
        proceedD(rs);

    }


    public void dauAC(View view) {
        txtCache = "0";
        maxLen = 9;
        txtShow.setText("0");
        so = new ArrayList<>();
        dau = new ArrayList<>();
        minus = false;
    }

    public void plusOrMinus(View view) {
        if (minus) minus = false;
        else minus = true;

        preProceed(txtCache, false);
    }

    public void percent(View view) {
        if (!txtCache.equals("")) {
            double soTxt = Double.parseDouble(txtCache);
            if (minus) soTxt = SimpleCalculation.sub(0, soTxt);
            double rs = SimpleCalculation.mul(soTxt, 0.01);
            so.add(rs);
            if (rs < 0) {
                txtCache = Double.toString(SimpleCalculation.sub(0, rs));
                minus = true;
            }
            else {
                txtCache = Double.toString(rs);
                minus = false;
            }
            proceedD(rs);
        }
//        else if (so.size() >= 1) {
//            double getSo = so.get(so.size() - 1);
//            double rs = SimpleCalculation.mul(getSo, 0.01);
//            so.set(so.size() - 1, rs);
//            txtCache = "";
//            proceedD(rs);
//        }
    }

    public void btnDau(View view) {
        if (!chonDau) so.add(Double.parseDouble(txtCache));
        txtCache = "0";
        switch (view.getId()) {
            case R.id.btnPlus:
                if (!chonDau) {
                    dau.add("+");
                }
                else {
                    dau.set(dau.size() - 1, "+");
                }
                selectBtn(1);
                break;
            case R.id.btnMinus:
                if (!chonDau) {
                    dau.add("-");
                }
                else {
                    dau.set(dau.size() - 1, "-");
                }
                selectBtn(2);
                break;
            case R.id.btnMul:
                if (!chonDau) {
                    dau.add("x");
                }
                else {
                    dau.set(dau.size() - 1, "x");
                }
                selectBtn(3);
                break;
            case R.id.btnDiv:
                if (!chonDau) {
                    dau.add("/");
                }
                else {
                    dau.set(dau.size() - 1, "/");
                }
                selectBtn(4);
                break;
        }

    }

    public void selectBtn(int btn) {
        switch (btn) {
            case 1:
                chonDau = true;
                btnPlus.setSelected(true);
                btnDiv.setSelected(false);
                btnMul.setSelected(false);
                btnMinus.setSelected(false);
                break;
            case 2:
                chonDau = true;
                btnPlus.setSelected(false);
                btnDiv.setSelected(false);
                btnMul.setSelected(false);
                btnMinus.setSelected(true);
                break;
            case 3:
                chonDau = true;
                btnPlus.setSelected(false);
                btnDiv.setSelected(false);
                btnMul.setSelected(true);
                btnMinus.setSelected(false);
                break;
            case 4:
                chonDau = true;
                btnPlus.setSelected(false);
                btnDiv.setSelected(true);
                btnMul.setSelected(false);
                btnMinus.setSelected(false);
                break;
            default:
                chonDau = false;
                btnPlus.setSelected(false);
                btnDiv.setSelected(false);
                btnMul.setSelected(false);
                btnMinus.setSelected(false);
                break;
        }
    }

    public void so(View view) {
        selectBtn(0);
        if (txtCache.length() < maxLen) {

            switch (view.getId()) {
                case R.id.so0:
                    txtCache += "0";
                    break;
                case R.id.so1:
                    txtCache += "1";
                    break;
                case R.id.so2:
                    txtCache += "2";
                    break;
                case R.id.so3:
                    txtCache += "3";
                    break;
                case R.id.so4:
                    txtCache += "4";
                    break;
                case R.id.so5:
                    txtCache += "5";
                    break;
                case R.id.so6:
                    txtCache += "6";
                    break;
                case R.id.so7:
                    txtCache += "7";
                    break;
                case R.id.so8:
                    txtCache += "8";
                    break;
                case R.id.so9:
                    txtCache += "9";
                    break;
            }

            preProceed(txtCache, false);

//            try {
//                while (txtCache.charAt(0) == '0' && txtCache.charAt(1) != '.' && txtCache.length() > 1) {
//                    txtCache = txtCache.substring(1);
//                }
//            } catch (Exception e) {
//
//            }

            //show(txtCache, false);
        }

    }

    public void dauCham(View view) {
        if (txtCache.length() < 9 && !txtCache.contains(".")) {
            txtCache += ".";
            maxLen += 1;
            preProceed(txtCache, false);
        }
    }

    public void calculating(View view) {
        so.add(Double.valueOf(txtCache));
        if (!so.isEmpty()) {
            runTest();
        }
    }

    public void proceedD(Double so) {

        boolean pE = false;

        String[] cut = null;

        try {
            cut = String.valueOf(so).split("E");
            try {
                if (!cut[1].isEmpty()) pE = true;
            } catch (Exception e) {}
        } catch (Exception e) {}

        if (pE && Integer.parseInt(cut[1]) > -9) {
            preProceed(String.format("%.8f", so), true);
        }
        else preProceed(String.valueOf(so), true);
    }

    public void preProceed(String so, boolean rs) {

        boolean dC = (so.contains(".")) ? true : false;
        boolean pT = false;
        boolean pE = false;
//      cut1[0] phần nguyên
//      cut2[0] phần thập phân
//      cut2[1] phần số mũ E

        String[] cut1 = so.split("\\.");
        String[] cut2 = null;
        try {
            if (!cut1[1].isEmpty()) {
                pT = true;
                cut2 = cut1[1].split("E");
                try {
                    if (!cut2[1].isEmpty()) pE = true;
                } catch (Exception e) {}
            }
        } catch (Exception e) {}

        String rsPI = proceedInt(cut1[0]);
        String rsR = "";
        try {
            if (pT) rsR = proceedR(cut2[0]);
        } catch (Exception e) {}
        String rsE = "";
        try {
            if (pE) rsE = cut2[1];
        } catch (Exception e) {}

        String lastRS = "";

        if (rs) {
            if (pT && !rsR.equals("")) {
                if (pE) {
                    lastRS = cut1[0] + "." + rsR + "E" + rsE;
                }
                else lastRS = cut1[0] + "." + rsR;
            }
            else if (pE) {
                lastRS = cut1[0] + "E" + rsE;
            }
            else lastRS = cut1[0];
            txtShow.setText(lastRS);
        }
        else {
            if (pT) lastRS = rsPI + "."  + cut2[0];
            else if (dC) lastRS = rsPI + ".";
            else lastRS = rsPI;

            if (minus) txtShow.setText("-" + lastRS);
            else txtShow.setText(lastRS);
        }


    }

    public String proceedInt(String so) {
        while (so.charAt(0) == '0' && so.length() > 1) {
            so = so.substring(1);
        }

        int len = so.length();
        int kc = len / 3;
        if (len % 3 == 0) kc--;

        String ns = "";
        int pos = 0;

        while (kc != 0) {
            ns += so.substring(pos, len - kc * 3) + ",";
            pos = len - kc * 3;
            kc--;
        }
        ns += so.substring(pos);

        return ns;
    }

    public String proceedR(String so) {
        while(so.length() > 0) {
            if (so.charAt(so.length() - 1) == '0') so = so.substring(0, so.length() - 1);
            else break;
        }
        return so;
    }

}