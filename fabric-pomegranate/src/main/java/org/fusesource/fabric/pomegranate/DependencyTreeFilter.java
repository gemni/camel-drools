/*
 * Copyright (C) 2011, FuseSource Corp.  All rights reserved.
 * http://fusesource.com
 *
 * The software in this package is published under the terms of the
 * CDDL license a copy of which has been included with this distribution
 * in the license.txt file.
 */
package org.fusesource.fabric.pomegranate;

import org.fusesource.fabric.pomegranate.util.Filter;

/**
 * Matches a {@link DependencyTree} using a groupId and artifactId filter
 */
public class DependencyTreeFilter implements Filter<DependencyTree> {
    private final Filter<String> groupFilter;
    private final Filter<String> artifactFilter;

    public DependencyTreeFilter(Filter<String> groupFilter, Filter<String> artifactFilter) {
        this.groupFilter = groupFilter;
        this.artifactFilter = artifactFilter;
    }

    @Override
    public boolean matches(DependencyTree dependencyTree) {
        String groupId = dependencyTree.getGroupId();
        String artifactId = dependencyTree.getArtifactId();
        return groupFilter.matches(groupId) && artifactFilter.matches(artifactId);
    }
}
