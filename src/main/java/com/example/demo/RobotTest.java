package com.example.demo;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotTest {
//!@#$%^&*()
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Delay before starting to type
            robot.delay(2000);

            // Type text with special characters
            typeText(robot, "a !@#$%^&*()");

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void typeText(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                // Handle special characters
                System.out.println("Special character: " + c);
            } else {
                // Type normal characters
                switch (c) {
                    case '!':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '@':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_2);
                        robot.keyRelease(KeyEvent.VK_2);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '&':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_7);
                        robot.keyRelease(KeyEvent.VK_7);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '#':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_3);
                        robot.keyRelease(KeyEvent.VK_3);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '$':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '%':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '^':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_6);
                        robot.keyRelease(KeyEvent.VK_6);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '*':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_8);
                        robot.keyRelease(KeyEvent.VK_8);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;

                    case '(':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_9);
                        robot.keyRelease(KeyEvent.VK_9);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case ')':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    default:
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                }

            }

            // Add a delay between key presses to make it readable
            robot.delay(50);
        }
    }





        }
