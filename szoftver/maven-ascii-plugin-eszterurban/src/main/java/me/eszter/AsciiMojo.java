package me.eszter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Mojo(name = "ascii-mojo", defaultPhase = LifecyclePhase.COMPILE)
public class AsciiMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        int random = ThreadLocalRandom.current().nextInt(3) + 1;
        try (var reader = new BufferedReader(new InputStreamReader(AsciiMojo.class.getResourceAsStream("/" + random + ".txt")))) {
            List<String> lines = reader.lines().toList();
            lines.forEach(l -> getLog().info(l));
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to read ascii art", e);
        }
    }
}
