package com.nlogic.domain.exception;


/**
 * The Class ExceptionTest.
 */
public class ExceptionTest {
	
	/** The exception handler. */
	protected IExceptionHandler exceptionHandler = new IExceptionHandler(){
        public void handle(String errorContext, String errorCode,
                           String errorText, Throwable t) throws EnrichableException{

            if(! (t instanceof EnrichableException)){
                throw new EnrichableException(
                    errorContext, errorCode, errorText, t);
            } else {
                ((EnrichableException) t).addInfo(
                    errorContext, errorCode, errorText);
            }
        }

        public void raise(String errorContext, String errorCode,
                          String errorText) throws EnrichableException{
            throw new EnrichableException(
                errorContext, errorCode, errorText);
        }
    };

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){
        ExceptionTest test = new ExceptionTest();
        try{
            test.level1();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Level1.
     *
     * @throws EnrichableException the enrichable exception
     */
    public void level1() throws EnrichableException{
        try{
            level2();
        } catch (EnrichableException e){
            this.exceptionHandler.handle(
                "L1", "E1", "Error in level 1, calling level 2", e);
            throw e;
        }
    }

    /**
     * Level2.
     *
     * @throws EnrichableException the enrichable exception
     */
    public void level2() throws EnrichableException{
        try{
            level3();
        } catch (EnrichableException e){
            this.exceptionHandler.handle(
                "L2", "E2", "Error in level 2, calling level 3", e);
            throw e;
        }
    }

    /**
     * Level3.
     *
     * @throws EnrichableException the enrichable exception
     */
    public void level3() throws EnrichableException{
        try{
            level4();
        } catch(Exception e){
            this.exceptionHandler.handle(
                "L3", "E3", "Error at level 3", e);
        }
    }

    /**
     * Level4.
     */
    public void level4(){
        throw new IllegalArgumentException("incorrect argument passed");
    }
}
