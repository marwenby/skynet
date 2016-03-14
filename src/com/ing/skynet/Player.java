package com.ing.skynet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/

class Link {

	private int node1;
	private int node2;

	public Link(int n1, int n2) {
		this.node1 = n1;
		this.node2 = n2;
	}

	public int getNode1() {
		return this.node1;
	}

	public int getNode2() {
		return this.node2;
	}

	public boolean equals(Object o) {
		Link link = (Link) o;
		return ((this.node1 == link.node1 && this.node2 == link.node2)
				|| (this.node2 == link.node1 && this.node1 == link.node2));
	}
}

class Player {

	public boolean block(int agentNode, List<Integer> gateways, List<Link> links) {

		for (int gateway : gateways) {
			Link link = new Link(agentNode, gateway);
			int linkIndex = links.indexOf(link);
			if (linkIndex >= 0) {
				System.out.println(link.getNode1() + " " + link.getNode2());
				links.remove(linkIndex);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Player player = new Player();

		int N = in.nextInt(); // the total number of nodes in the level,
								// including the gateways
		int L = in.nextInt(); // the number of links
		int E = in.nextInt(); // the number of exit gateways

		List<Link> links = new ArrayList<Link>();
		List<Integer> gateways = new ArrayList<Integer>();

		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt(); // N1 and N2 defines a link between these
									// nodes
			int N2 = in.nextInt();
			links.add(new Link(N1, N2));
		}
		for (int i = 0; i < E; i++) {
			int EI = in.nextInt(); // the index of a gateway node
			gateways.add(EI);
		}

		// game loop
		while (true) {
			int SI = in.nextInt(); // The index of the node on which the Skynet
									// agent is positioned this turn

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");
			if (!player.block(SI, gateways, links)) {
				System.out.println(links.get(0).getNode1() + " " + links.get(0).getNode2());
				links.remove(0);
			}

		}
	}
}