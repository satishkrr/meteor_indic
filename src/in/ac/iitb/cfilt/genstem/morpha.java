package in.ac.iitb.cfilt.genstem;

/* gives the synset_id 0f the words*/
import java.io.BufferedWriter;
import java.io.FileWriter;

public class morpha {
	public static void main(String args[]) throws Exception {
		FileWriter fstream = new FileWriter(
				"/home/lavita/workspace/Trie/english results/morpha_health_final");
		BufferedWriter out = new BufferedWriter(fstream);
		String line = null;
		String line1 = null;
		String line2 = null;
		String wordnet_word = null;
		String corpus_word = null;

		String field[] = null;
		String fields[] = null;

		UTFReader lexicon = new UTFReader(
				"/home/lavita/workspace/Trie/english results/snowball_health_edited");
		;
		lexicon.open();
		while ((line = lexicon.readLine()) != null) {
			// Traverses Corpus
			field = line.split(" ");
			corpus_word = field[1];
			// System.out.println(corpus_word);
			UTFReader lexicon1 = new UTFReader(
					"/home/lavita/workspace/Trie/english results/morpha_health.txt");
			lexicon1.open();
			while ((line1 = lexicon1.readLine()) != null) {
				fields = line1.split(" ");
				wordnet_word = fields[0];
				// System.out.println(line1);
				if (corpus_word.equals(wordnet_word)) {
					System.out.println(field[0] + " " + field[1] + " " + "["
							+ fields[1] + "]");
					out.write(field[0] + " " + field[1] + " " + "[" + fields[1]
							+ "]");
					out.write("\n");
				}
			}

			lexicon1.close();
		}
		out.close();
		lexicon.close();
	}
}
