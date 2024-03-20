package chap05_재귀알고리즘;

public class tmp {
	void path(int m, int p)
	// Output a path (if any) in the maze; rows is m, cols is p;
	{
		//start at (1,1)
		mark[1][1] = 1;
	    maze[1][1] = 2;
		Stack<items> stack(m * p);
		items temp;
		temp.x = 1; temp.y = 1; temp.dir = E;
		stack.Push(temp);
		while (!stack.IsEmpty( )) // stack not empty
		{
			temp = stack.Pop( ); // unstack
			int i = temp.x; int j = temp.y; int d = temp.dir;
			while (d < 8) // moves forward
			{
				//outFile << i << " " << j << " " << d << endl;
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) { // reached exit// output path
					cout << stack;

					cout << "the term near the exit: " << i << " " << j << endl;
					cout << "exit: " << m << " " << p << endl;

	                while(!stack.IsEmpty()){
	                    temp = stack.Pop();
	                    maze[temp.x][temp.y] = 2;
	                }

	                // 탈출 경로
	                cout << "\n --------- Escape Loot ---------- \n";
	                for (int x = 0; x < 14; x++) {
	                    for (int y = 0; y < 17; y++)
	                        cout << maze[x][y] << ' ';
	                    cout << '\n';
	                }

					return;
				}
				if ((!maze[g][h]) && (!mark[g][h])) { // new position
					mark[g][h] = 1;
					//push the old temp to the stack, but the direction changes.
					//Because the neighbor in the direction of d has been checked.
					temp.x = i;  temp.y = j; temp.dir = d + 1;
					stack.Push(temp); // stack it
	                i = g; j = h; d = N; // moves to (g,h)
				}
				else d++; // try next direction
			}
		}
		cout << "no path in maze " << endl;
	}
}
