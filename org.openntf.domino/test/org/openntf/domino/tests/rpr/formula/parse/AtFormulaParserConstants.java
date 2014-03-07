/* Generated By:JJTree&JavaCC: Do not edit this line. AtFormulaParserConstants.java */
package org.openntf.domino.tests.rpr.formula.parse;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface AtFormulaParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int Date_or_KW = 1;
  /** RegularExpression Id. */
  int OSubscript = 2;
  /** RegularExpression Id. */
  int CSubscript = 3;
  /** RegularExpression Id. */
  int EOS = 4;
  /** RegularExpression Id. */
  int OParen = 5;
  /** RegularExpression Id. */
  int CParen = 6;
  /** RegularExpression Id. */
  int Assign = 7;
  /** RegularExpression Id. */
  int BoolNot = 8;
  /** RegularExpression Id. */
  int KW_DEFAULT = 9;
  /** RegularExpression Id. */
  int KW_ENVIRONMENT = 10;
  /** RegularExpression Id. */
  int KW_FIELD = 11;
  /** RegularExpression Id. */
  int KW_REM = 12;
  /** RegularExpression Id. */
  int KW_SELECT = 13;
  /** RegularExpression Id. */
  int At_do = 14;
  /** RegularExpression Id. */
  int At_doWhile = 15;
  /** RegularExpression Id. */
  int At_for = 16;
  /** RegularExpression Id. */
  int At_if = 17;
  /** RegularExpression Id. */
  int At_iferror = 18;
  /** RegularExpression Id. */
  int At_transform = 19;
  /** RegularExpression Id. */
  int At_other = 20;
  /** RegularExpression Id. */
  int ListConcat = 21;
  /** RegularExpression Id. */
  int OpMul = 22;
  /** RegularExpression Id. */
  int OpMulP = 23;
  /** RegularExpression Id. */
  int OpDiv = 24;
  /** RegularExpression Id. */
  int OpDivP = 25;
  /** RegularExpression Id. */
  int OpPlus = 26;
  /** RegularExpression Id. */
  int OpPlusP = 27;
  /** RegularExpression Id. */
  int OpMinus = 28;
  /** RegularExpression Id. */
  int OpMinusP = 29;
  /** RegularExpression Id. */
  int CmpEqual = 30;
  /** RegularExpression Id. */
  int CmpEqualP = 31;
  /** RegularExpression Id. */
  int CmpNE = 32;
  /** RegularExpression Id. */
  int CmpNEP = 33;
  /** RegularExpression Id. */
  int CmpLT = 34;
  /** RegularExpression Id. */
  int CmpLTP = 35;
  /** RegularExpression Id. */
  int CmpGT = 36;
  /** RegularExpression Id. */
  int CmpGTP = 37;
  /** RegularExpression Id. */
  int CmpLTE = 38;
  /** RegularExpression Id. */
  int CmpLTEP = 39;
  /** RegularExpression Id. */
  int CmpGTE = 40;
  /** RegularExpression Id. */
  int CmpGTEP = 41;
  /** RegularExpression Id. */
  int BoolAnd = 42;
  /** RegularExpression Id. */
  int BoolOr = 43;
  /** RegularExpression Id. */
  int NumDoubleUS = 44;
  /** RegularExpression Id. */
  int NumDoubleDE = 45;
  /** RegularExpression Id. */
  int NumInteger = 46;
  /** RegularExpression Id. */
  int Exponent = 47;
  /** RegularExpression Id. */
  int String1 = 48;
  /** RegularExpression Id. */
  int String2 = 49;
  /** RegularExpression Id. */
  int Identifier = 50;
  /** RegularExpression Id. */
  int Letter = 51;
  /** RegularExpression Id. */
  int Digit = 52;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int SUBSCRIPT = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<Date_or_KW>",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\"(\"",
    "\")\"",
    "\":=\"",
    "\"!\"",
    "\"DEFAULT\"",
    "\"ENVIRONMENT\"",
    "\"FIELD\"",
    "\"REM\"",
    "\"SELECT\"",
    "\"@do\"",
    "\"@doWhile\"",
    "\"@for\"",
    "\"@if\"",
    "\"@iferror\"",
    "\"@transform\"",
    "<At_other>",
    "\":\"",
    "\"*\"",
    "\"**\"",
    "\"/\"",
    "\"*/\"",
    "\"+\"",
    "\"*+\"",
    "\"-\"",
    "\"*-\"",
    "\"=\"",
    "\"*=\"",
    "<CmpNE>",
    "\"*<>\"",
    "\"<\"",
    "\"*<\"",
    "\">\"",
    "\"*>\"",
    "\"<=\"",
    "\"*<=\"",
    "\">=\"",
    "\"*>=\"",
    "\"&\"",
    "\"|\"",
    "<NumDoubleUS>",
    "<NumDoubleDE>",
    "<NumInteger>",
    "<Exponent>",
    "<String1>",
    "<String2>",
    "<Identifier>",
    "<Letter>",
    "<Digit>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\r\\n\"",
  };

}
