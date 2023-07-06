import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaComponents } from './tabella.component';

describe('TabellaComponent', () => {
  let component: TabellaComponents;
  let fixture: ComponentFixture<TabellaComponents>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TabellaComponents]
    });
    fixture = TestBed.createComponent(TabellaComponents);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
