package com.qualcomm.ftcrobotcontroller.opmodes;

        import android.graphics.Color;

        import com.qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import java.lang.*;

public class WR_CDS_Ramp extends LinearOpMode {

    DcMotor M1, M2, M3, M4, collector, launcher;
    ColorSensor sensorRGB_Back;
    ColorSensor sensorRGB_Front;
    Servo Arm;

    public void runOpMode() throws InterruptedException {
        M1 = hardwareMap.dcMotor.get("1");
        M2 = hardwareMap.dcMotor.get("2");
        M3 = hardwareMap.dcMotor.get("3");
        M4 = hardwareMap.dcMotor.get("4");
        collector = hardwareMap.dcMotor.get("collector");
        launcher = hardwareMap.dcMotor.get("launcher");
        Arm = hardwareMap.servo.get("Servo");

        hardwareMap.logDevices();
        sensorRGB_Back = hardwareMap.colorSensor.get("color_Back");
        sensorRGB_Front = hardwareMap.colorSensor.get("color_Front");

        boolean bEnabled = true;
        sensorRGB_Back.enableLed(false);
        sensorRGB_Front.enableLed(false);
        float hsvValuesfront[] = {0F, 0F, 0F};
        float hsvValuesback[] = {0F, 0F, 0F};


        M1.setDirection(DcMotor.Direction.FORWARD);
        M2.setDirection(DcMotor.Direction.FORWARD);
        M3.setDirection(DcMotor.Direction.REVERSE);
        M4.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        sleep(15000);      //delay 15 seconds
        M1.setPower(.3);
        M2.setPower(-.3);
        M3.setPower(.3);
        M4.setPower(-.3);
        sleep(1000);      //move foward and get the robot to the right spot to shoot

        M1.setPower(0);
        M2.setPower(0);
        M3.setPower(0);
        M4.setPower(0);
        sleep(100);   // Stop the robot and give it .1 sec to stabalize

        launcher.setPower(1);
        sleep(4500);   //launch particles for 4.5 seconds - three flipper turns
        launcher.setPower(0); //Turn fliper off

        M1.setPower(-1);
        M2.setPower(-1);
        M3.setPower(-1);
        M4.setPower(-1);
        sleep(250);       //rotate 35 degrees

        M1.setPower(0);
        M2.setPower(0);
        M3.setPower(0);
        M4.setPower(0);
        sleep(500); //  Settle the robot before moving

        M1.setPower(1);
        M2.setPower(-1);
        M3.setPower(1);
        M4.setPower(-1);
        sleep(2000);        //move foward to the front of ramp

        M1.setPower(0);
        M2.setPower(0);
        M3.setPower(0);
        M4.setPower(0);
        sleep(500); //  Settle the robot before moving

        M1.setPower(-1);
        M2.setPower(-1);
        M3.setPower(-1);
        M4.setPower(-1);
        sleep(375);       //rotate 45 degrees

        M1.setPower(0);
        M2.setPower(0);
        M3.setPower(0);
        M4.setPower(0);
        sleep(500);  // Settle the robot before spinning

        M1.setPower(0.5);
        M2.setPower(-0.5);
        M3.setPower(0.5);
        M4.setPower(-0.5);
        sleep(1600);        //move foward on to the ramp

        M1.setPower(0);
        M2.setPower(0);
        M3.setPower(0);
        M4.setPower(0);
        //ends the autonomous
    }
}