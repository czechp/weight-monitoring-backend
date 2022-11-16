package app.web.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
class ModuleInfo {
    private final long moduleId;
    private final String lineName;
}
