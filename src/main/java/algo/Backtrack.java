package algo;

public abstract class Backtrack<I> {
	
	private boolean finished;
	
	public final void backtrack(int a[], int k, I input) {
		
		if (isASolution(a, k, input)) {
			processSolution(a, k, input);
		} else {
			k = k + 1;
			int[] c = constructCandidates(a, k, input);
			for (int i = 0; i < c.length; i++) {
				a[k] = c[i];
				makeMove(a, k, input);
				backtrack(a, k, input);
				unmakeMove(a, k, input);
				if (finished) return;
			}
		}
	}

	protected abstract void unmakeMove(int[] a, int k, I input);

	protected abstract void makeMove(int[] a, int k, I input);

	protected abstract int[] constructCandidates(int[] a, int k, I input);

	protected abstract void processSolution(int[] a, int k, I input);

	protected abstract boolean isASolution(int[] a, int k, I input);

	/**
	 * Set finished flag to true.
	 */
	protected void finish() {
		this.finished = true;
	}
}
