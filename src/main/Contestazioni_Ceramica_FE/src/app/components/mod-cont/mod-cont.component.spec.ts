import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModContComponent } from './mod-cont.component';

describe('ModContComponent', () => {
  let component: ModContComponent;
  let fixture: ComponentFixture<ModContComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModContComponent]
    });
    fixture = TestBed.createComponent(ModContComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
