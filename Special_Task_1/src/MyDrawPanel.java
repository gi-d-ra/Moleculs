import ChemicalElements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyDrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    boolean isH;
    boolean isO;
    boolean isC;
    boolean isN;
    boolean isSq;
    boolean isLine;
    boolean isDelete;

    //    boolean flag = true;
//    boolean isFirst = true;
    MyLine myLine;

    int prevX;
    int prevY;
    int index;
    int clic;

    ArrayList<MyFigure> elements;

    public MyDrawPanel(LayoutManager layout) {
        super(layout);
        elements = new ArrayList<>();
        addMouseMotionListener(this);
        addMouseListener(this);
        clic = 0;
        myLine = new MyLine();
    }

//    public MyDrawPanel() {
//        elements = new ArrayList<>();
//        elements.add(new H());
//        elements.add(new O());
//        elements.add(new C());
//        elements.add(new N());
//        elements.add(new Sq());
//        elements.add(new MyLine());
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Удаление последнего элемента

//        if (isDelete) {
//            if (elements.size() != 0) {
//                remove(elements.get(elements.size() - 1));
//                elements.remove(elements.size() - 1);
//            }
//            isDelete = false;
//        }


        // Прорисовка добавленных ранее элементов

        for (MyFigure f : elements) {
            if (f instanceof MyLine) {
                g.drawLine(((MyLine) f).getX1(), ((MyLine) f).getY1(), ((MyLine) f).getX2(), ((MyLine) f).getY2());
            } else {
                g.drawImage(((ChemicalElement) f).getImage(), f.getX(), f.getY(), this);
            }
        }


        // Добавление новых элементов

        if (isH) {
            isH = false;
            H myH = new H();
            elements.add(myH);
            int last = elements.size() - 1;
            g.drawImage(myH.getImage(), elements.get(last).getX(), elements.get(last).getY(), null);
        }
        if (isC) {
            isC = false;
            C myC = new C();
            elements.add(myC);
            int last = elements.size() - 1;
            g.drawImage(myC.getImage(), elements.get(last).getX(), elements.get(last).getY(), this);
        }
        if (isO) {
            isO = false;
            O myO = new O();
            elements.add(myO);
            int last = elements.size() - 1;
            g.drawImage(myO.getImage(), elements.get(last).getX(), elements.get(last).getY(), this);
        }
        if (isN) {
            isN = false;
            N myN = new N();
            elements.add(myN);
            int last = elements.size() - 1;
            g.drawImage(myN.getImage(), elements.get(last).getX(), elements.get(last).getY(), this);
        }
        if (isSq) {
            isSq = false;
            Sq mySq = new Sq();
            elements.add(mySq);
            int last = elements.size() - 1;
            g.drawImage(mySq.getImage(), elements.get(last).getX(), elements.get(last).getY(), this);
        }
//        if (isLine) {
//            boolean isFirst = true;
//            Iterator<Point> it = points.iterator();
//            MyLine myLine = new MyLine();
//            while (it.hasNext()) {
//                Point p = it.next();
//                if (isFirst) {
//                    myLine = new MyLine(p);
//                    isFirst = false;
//                }
//                if (it.hasNext()) {
//                    Point p1 = it.next();
//                    g.drawLine((int) p.getX(), (int) p.getY(), (int) p1.getX(), (int) p1.getY());
//                    myLine.setX2((int) p1.getX());
//                    myLine.setY2((int) p1.getY());
//                }
//            }
//            elements.add(myLine);
////            MyLine myLine = new MyLine(lineX1, lineY1, lineX2, lineY2);
////            elements.add(myLine);
////            g.drawLine(myLine.getX(), myLine.getY(), myLine.getX2(), myLine.getY2());
//            isLine = false;
//        }
    }

    public void addH() {
        isH = true;
        repaint();
    }

    public void addO() {
        isO = true;
        repaint();
    }

    public void addC() {
        isC = true;
        repaint();
    }

    public void addN() {
        isN = true;
        repaint();
    }

    public void addSq() {
        isSq = true;
        repaint();
    }

    public void addLine() {
        isLine = true;
    }

    public void deleteLast() {
        isDelete = true;
    }

    // Перемещение элементов

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isLine) {
            clic++;
            if (clic == 1) {
                myLine.setX1(e.getX());
                myLine.setY1(e.getY());
            } else {
                myLine.setX2(e.getX());
                myLine.setY2(e.getY());
                isLine = false;
            }
            if (clic == 2) {
                MyLine ln = new MyLine(myLine);
                elements.add(ln);
                clic = 0;
                repaint();
            }
        }

        if (isDelete) {
            isDelete = false;
            if (elements.size() != 0) {
                for (int i = elements.size() - 1; i >= 0; i--) {
                    if (elements.get(i) instanceof MyLine) {
                        if (((e.getX() > ((MyLine) elements.get(i)).getX1() - 30) && (e.getY() > ((MyLine) elements.get(i)).getY1() - 30)
                                && (e.getX() < ((MyLine) elements.get(i)).getX1() + 30) && (e.getX() < ((MyLine) elements.get(i)).getY1() + 30)) ||
                                ((e.getX() > ((MyLine) elements.get(i)).getX2() - 30) && (e.getY() > ((MyLine) elements.get(i)).getY2() - 30) &&
                                        (e.getX() < ((MyLine) elements.get(i)).getX2() + 30) && (e.getX() < ((MyLine) elements.get(i)).getY2() + 30))) {
//                        Component c = e.getComponent();
//                        if (c instanceof MyFigure) {
                            elements.remove(i);
//                        }
                            break;
                        }
                    } else {
                        if ((e.getX() > elements.get(i).getX()) && (e.getX() < elements.get(i).getX() + 100) &&
                                (e.getY() > elements.get(i).getY()) && (e.getY() < elements.get(i).getY() + 100)) {
//                        Component c = e.getComponent();
//                        if (c instanceof MyFigure) {
                            elements.remove(i);
//                        }
                            break;
                        }
                    }
                }
                repaint();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            if ((e.getX() > elements.get(i).getX()) && (e.getX() < elements.get(i).getX() + 100) &&
                    (e.getY() > elements.get(i).getY()) && (e.getY() < elements.get(i).getY() + 100)) {
                prevX = elements.get(i).getX() - e.getX();
                prevY = elements.get(i).getY() - e.getY();
                index = i;
                Component c = e.getComponent();
                if (c instanceof MyFigure) {
                    updateLocation(e);
                }
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            if ((e.getX() > elements.get(i).getX()) && (e.getX() < elements.get(i).getX() + 100) &&
                    (e.getY() > elements.get(i).getY()) && (e.getY() < elements.get(i).getY() + 100)) {
                Component c = e.getComponent();
                if (c instanceof MyFigure) {
                    updateLocation(e);
                }
                break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            if ((e.getX() > elements.get(i).getX()) && (e.getX() < elements.get(i).getX() + 100) &&
                    (e.getY() > elements.get(i).getY()) && (e.getY() < elements.get(i).getY() + 100)) {
                updateLocation(e);
                break;
            }
        }

//        if(isLine){
//            points.add(new Point(e.getX(), e.getY()));
//            repaint();
//        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void updateLocation(MouseEvent e) {
        elements.get(index).setLocation(prevX + e.getX(), prevY + e.getY());
        repaint();
    }
}
