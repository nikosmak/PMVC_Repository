/**
 * 
 */
package com.nlogic.domain.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class EnrichableException.
 *
 * @author nikosmak
 */
public class EnrichableException extends Exception{
	
	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = -1;

    /** The info items. */
    protected List<InfoItem> infoItems = new ArrayList<InfoItem>();

    /**
     * The Class InfoItem.
     */
    protected class InfoItem{
        
        /** The error context. */
        public String errorContext = null;
        
        /** The error code. */
        public String errorCode  = null;
        
        /** The error text. */
        public String errorText  = null;
        
        /**
         * Instantiates a new info item.
         *
         * @param contextCode the context code
         * @param errorCode the error code
         * @param errorText the error text
         */
        public InfoItem(String contextCode, String errorCode,
                                     String errorText){

            this.errorContext = contextCode;
            this.errorCode   = errorCode;
            this.errorText   = errorText;
        }
    }


    /**
     * Instantiates a new enrichable exception.
     *
     * @param errorContext the error context
     * @param errorCode the error code
     * @param errorMessage the error message
     */
    public EnrichableException(String errorContext, String errorCode,
                               String errorMessage){

        addInfo(errorContext, errorCode, errorMessage);
    }

    /**
     * Instantiates a new enrichable exception.
     *
     * @param errorContext the error context
     * @param errorCode the error code
     * @param errorMessage the error message
     * @param cause the cause
     */
    public EnrichableException(String errorContext, String errorCode,
                               String errorMessage, Throwable cause){
        super(cause);
        addInfo(errorContext, errorCode, errorMessage);
    }

    /**
     * Adds the info.
     *
     * @param errorContext the error context
     * @param errorCode the error code
     * @param errorText the error text
     * @return the enrichable exception
     */
    public EnrichableException addInfo(
        String errorContext, String errorCode, String errorText){

        this.infoItems.add(
            new InfoItem(errorContext, errorCode, errorText));
        return this;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode(){
        StringBuilder builder = new StringBuilder();

        for(int i = this.infoItems.size()-1 ; i >=0; i--){
            InfoItem info =
                this.infoItems.get(i);
            builder.append('[');
            builder.append(info.errorContext);
            builder.append(':');
            builder.append(info.errorCode);
            builder.append(']');
        }

        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(getCode());
        builder.append('\n');


        //append additional context information.
        for(int i = this.infoItems.size()-1 ; i >=0; i--){
            InfoItem info =
                this.infoItems.get(i);
            builder.append('[');
            builder.append(info.errorContext);
            builder.append(':');
            builder.append(info.errorCode);
            builder.append(']');
            builder.append(info.errorText);
            if(i>0) builder.append('\n');
        }

        //append root causes and text from this exception first.
        if(getMessage() != null) {
            builder.append('\n');
            if(getCause() == null){
                builder.append(getMessage());
            } else if(!getMessage().equals(getCause().toString())){
                builder.append(getMessage());
            }
        }
        appendException(builder, getCause());

        return builder.toString();
    }

    /**
     * Append exception.
     *
     * @param builder the builder
     * @param throwable the throwable
     */
    private void appendException(
            StringBuilder builder, Throwable throwable){
        if(throwable == null) return;
        appendException(builder, throwable.getCause());
        builder.append(throwable.toString());
        builder.append('\n');
    }
}
