import OrmondEngine.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class window {

    float[] vertPos = {0.05f, -0.05f};
    float[] pongPos = {0.022f, -0.022f, 0.02f, -0.02f};
    boolean pongDir = false; // false is left, true is right    
    boolean pongHit = false;
    int poneScore = 0;
    int ptwoScore = 0;

    public window() {
        OrmondApplicationManager.startApp();

        OrmondWindowManager.init();
        long window = OrmondWindowManager.newWindow("Pong", 1280, 720, 0L, 0L);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        while(!glfwWindowShouldClose(window)) {
            glfwPollEvents();
            
	    getInput(window);
	     
            glClearColor(0f, 0f,0f, 1f);

            glClear(GL_COLOR_BUFFER_BIT);

            glEnable(GL_TEXTURE_2D);

            glBegin(GL_QUADS);
                glVertex2f(1f, 1f);
                glVertex2f(-1f ,1f);
                glVertex2f(-1f, -1f);
                glVertex2f(1f, -1f);
            glEnd();

            glBegin(GL_QUADS);
                glColor3f( 0f, 0f, 0f);
                glVertex2f(0.99f, 0.99f);
                glVertex2f(-0.99f ,0.99f);
                glVertex2f(-0.99f, -0.99f);
                glVertex2f(0.99f, -0.99f);
            glEnd();

            glBegin(GL_QUADS);
                glColor3f(1f, 1f, 1f);
                glVertex2f(-0.94f, vertPos[0]);
                glVertex2f(-0.93f, vertPos[0]);
                glVertex2f(-0.93f, vertPos[1]);
                glVertex2f(-0.94f, vertPos[1]);
            glEnd();

	    glBegin(GL_QUADS);
	    	glVertex2f(pongPos[0], pongPos[2]);
		glVertex2f(pongPos[1], pongPos[2]);
		glVertex2f(pongPos[1], pongPos[3]);
		glVertex2f(pongPos[0], pongPos[3]);
	    glEnd();

            glfwSwapBuffers(window);
        }

        glfwTerminate();

    }

    void getInput(long window) {
        if (glfwGetKey(window, GLFW_KEY_UP) == 1) {
            if (vertPos[0] < 0.94f) {
                vertPos[0] += 0.01f;
                vertPos[1] += 0.01f;
            }
        } else if (glfwGetKey(window, GLFW_KEY_DOWN) == 1) {
            if (vertPos[1] > -0.94f) {
                vertPos[0] -= 0.01f;
                vertPos[1] -= 0.01f;
            }
        }
    }

    void updatePong() {
    	if (pongHit) {
	    if (pongDir = true) {
		    pongDir = false;
	    } else {
		    pongDir = true;
	    }
	    pongHit = false;
	} else {
	    if (pongDir = true {
		    ptwoScore++;
		    pongDir = false;
	    } else {
		    poneScore++;
		    pongDir = true;
	    }
	    System.out.println("P1 - " + poneScore + "\nP2 - " + ptwoScore;
	}
    }

    public static void main(String[] args) {
        new window();
    }
}
