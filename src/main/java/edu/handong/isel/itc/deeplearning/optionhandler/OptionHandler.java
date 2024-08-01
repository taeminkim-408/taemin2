package edu.handong.isel.itc.deeplearning.optionhandler;

import org.apache.commons.cli.*;

public class OptionHandler {

    public void setCommand(String command) {
        this.command = command;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    private String command;
    private String filename;
    private String filename2;

    public Options createOptions() {
        Options options = new Options();

        options.addOption(Option.builder("f").longOpt("filepath")
                .desc("Set the filepath for the data. you must put the FILEPATH")
                .hasArg()
                .argName("file-path")
                .required()
                .build());


        options.addOption(Option.builder("c").longOpt("command")
                .desc("Set the command like '-L' ")
                .hasArg()
                .argName("command")
                .required()
                .build());

        return options;
    }

    public boolean parseOptions(Options options, String[] args) {
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            filename = cmd.getOptionValue("f");

            command = cmd.getOptionValue("c");

        } catch (ParseException e) {
            printHelp(options);
            return false;
        }
        return true;
    }

    private void printHelp(Options options) {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        String header = "CLI test program";
        String footer = "\nPlease report issues at https://github.com/HGUISEL/CLIExample/issues";
        formatter.printHelp("Untitled", header, options, footer, true);
    }

    public String getFilename() {
        return filename;
    }

    public String getCommand() {
        return command;
    }
}
