import OrmondEngine.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class window {
    public window() {
        OrmondApplicationManager.startApp();

        OrmondWindowManager.init();
        long window = OrmondWindowManager.newWindow("Pong", 1280, 720, 0L, 0L);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        float vertTop = 0.05f;
        float vertBot = -0.05f;

        while(!glfwWindowShouldClose(window)) {
            glfwPollEvents();
            float[] vertPos = getInputs(window, new float[]{vertTop, vertBot});
            vertTop = vertPos[0];
            vertBot = vertPos[1];
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
                glColor3f( 1f, 1f, 1f);
                glVertex2f(-0.94f, vertTop);
                glVertex2f(-0.93f, vertTop);
                glVertex2f(-0.93f, vertBot);
                glVertex2f(-0.94f, vertBot);
            glEnd();

            glfwSwapBuffers(window);
        }

        glfwTerminate();

    }

    float[] getInputs(long window, float[] vertPos) {
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
        return vertPos;
    }

    public static void main(String[] args) {
        new window();
    }
}
