package keepsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Fenzhi extends RecursiveTask<List<Point>> {

	private static final long serialVersionUID = 4640145013682438632L;
	public static final int threshold = 500;

	private  int start;

	private  int end;

	Fenzhi(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected List<Point> compute() {

		List<Point> taltolList= new ArrayList<>();
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) <= threshold;
		if (canCompute) {
			List<Point> pointList = new ArrayList<Point>();
			List<Double> listX = Lei.getListX();
			List<Double> listY = Lei.getListY();
			for (int i = start; i <= end; i++) {
				double x = listX.get(i);
				double y = listY.get(i);
				Point p = new Point();
				p.setX(x);
				p.setY(y);
				pointList.add(p);
			}
			Melkman m2 = new Melkman(pointList);
			List<Point> tubaoPoint2 = m2.getTubaoPoint();
			taltolList.addAll(tubaoPoint2);
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			Fenzhi leftTask = new Fenzhi(start, middle);
			Fenzhi rightTask = new Fenzhi(middle + 1, end);

			// 执行子任务
			leftTask.fork();
			rightTask.fork();

			// 等待任务执行结束合并其结果
			List<Point> leftResult = leftTask.join();
			List<Point> rightResult = rightTask.join();
			leftResult.addAll(rightResult);
			taltolList.addAll(leftResult);
			//return leftResult;
		}
		return taltolList;
	}

}
