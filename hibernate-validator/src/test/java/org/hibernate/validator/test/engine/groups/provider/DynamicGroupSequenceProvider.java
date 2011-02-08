/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibernate.validator.test.engine.groups.provider;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.group.DefaultGroupSequenceProvider;

/**
 * @author Kevin Pollet - SERLI - (kevin.pollet@serli.com)
 */
public class DynamicGroupSequenceProvider implements DefaultGroupSequenceProvider<User> {

	public List<Class<?>> getValidationGroups(User user) {
		List<Class<?>> defaultGroupSequence = new ArrayList<Class<?>>();
		defaultGroupSequence.add( User.class );

		if ( user.isAdmin() ) {
			defaultGroupSequence.add( StrongCheck.class );
		}

		return defaultGroupSequence;
	}

}