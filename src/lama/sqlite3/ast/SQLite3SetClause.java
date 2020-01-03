package lama.sqlite3.ast;

import lama.Randomly;
import lama.sqlite3.schema.SQLite3Schema.SQLite3Column.CollateSequence;

public class SQLite3SetClause extends SQLite3Expression {

	private final SQLite3Expression left;
	private final SQLite3Expression right;
	private final SQLite3ClauseType type;

	public static enum SQLite3ClauseType {
		UNION("UNION"), UNION_ALL("UNION ALL"), INTERSECT("INTERSECT"), EXCEPT("EXCEPT");
		
		private final String textRepresentation;

		private SQLite3ClauseType(String textRepresentation) {
			this.textRepresentation = textRepresentation;
		}
		
		public static SQLite3ClauseType getRandom() {
			return Randomly.fromOptions(values());
		}
		
		public String getTextRepresentation() {
			return textRepresentation;
		}
	}
	
	public SQLite3SetClause(SQLite3Expression left, SQLite3Expression right, SQLite3ClauseType type) {
		this.left = left;
		this.right = right;
		this.type = type;
	}

	public SQLite3Expression getLeft() {
		return left;
	}
	
	public SQLite3Expression getRight() {
		return right;
	}
	
	public SQLite3ClauseType getType() {
		return type;
	}
	
	@Override
	public CollateSequence getExplicitCollateSequence() {
		// TODO Auto-generated method stub
		return null;
	}

}
